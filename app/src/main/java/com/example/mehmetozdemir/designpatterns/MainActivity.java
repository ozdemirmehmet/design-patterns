package com.example.mehmetozdemir.designpatterns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.chainOfResponsibility.Function;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.chainOfResponsibility.FunctionA;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.chainOfResponsibility.FunctionB;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.chainOfResponsibility.FunctionC;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command.Lamp;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command.LampButtons;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command.LampCloseCommand;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.command.LampOpenCommand;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.interpreter.MinusSymbol;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.interpreter.PercentSymbol;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.interpreter.PlusSymbol;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.interpreter.Symbol;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.mediator.DeviceMediator;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.mediator.ElectronicDevice;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.mediator.Radio;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.mediator.Television;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.memento.Document;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.memento.DocumentReminder;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.memento.DocumentWriter;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.observer.CustomerType1;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.observer.CustomerType2;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.observer.PriceTopic;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.state.BankAccount;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.state.ForeignCurrencyBankAccount;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.strategy.LoanShark;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.strategy.MethodA;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.strategy.MethodB;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.templateMethod.Cooker;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.templateMethod.RiceMaker;
import com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.templateMethod.SoupMaker;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.abstractFactory.FastOrderSelector;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.abstractFactory.INotification;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.abstractFactory.IOrder;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.abstractFactory.IPay;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.abstractFactory.NormalOrderSelector;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.builder.Computer;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.factoryMethod.IPictureFormat;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.factoryMethod.FormatSelector;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.prototype.Picture;
import com.example.mehmetozdemir.designpatterns.CreationalDesignPatterns.singleton.TestObject;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.adapter.Address;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.adapter.Customer;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.adapter.CustomerBillAddressAdapter;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.composite.TeamManager;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.composite.TeamMember;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.decorator.CameraPhoneDecorator;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.decorator.MMSPhoneDecorator;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.decorator.Phone;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.decorator.SimplePhone;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.flyweight.Character;
import com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.flyweight.CharacterCreator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Singleton design pattern
        TestObject singletonPattern = TestObject.getTestObject();
        Log.d("Singleton => ", singletonPattern.getName() + " " + singletonPattern.getSurname());


        Log.d("Design Patterns", "*****************************************************************");
        //Factory Method design pattern
        //Resim boyutları
        int widht = 10;
        int height = 50;
        //Format seçici nesnenin oluşturulması
        FormatSelector formatSelector = new FormatSelector();
        //Yeni bir resim formatı oluşurulur ve format seçici sınıfının
        //döndürdüğü format değeri bu nesneye atanır.
        IPictureFormat pictureFormat = formatSelector.getFormat(widht, height);
        //Yapılan seçilime uygun resim formatında resim oluşturulur.
        pictureFormat.createPicture(widht, height);


        Log.d("Design Patterns", "*****************************************************************");
        //Abstract Factory Method design pattern
        boolean orderStyle = true; //true = fast order, false = normal order
        //Order interface i tanımladık.
        IOrder order = null;
        //Order interface' ine istenen sipariş türüne uygun bildirim ve ödeme
        //türü seçilimlerini yapacak sipariş seçiciler atanır.
        if(orderStyle)
            order = new FastOrderSelector();
        else
            order = new NormalOrderSelector();
        //Yeni bildirim ve ödeme nesneleri tanımlanır ve bunlara
        //belirlenen sipariş seçiciler yardımıyla uygun bildirim ve ödeme tipi nesneleri
        //atanır.
        INotification notificationStyle = order.createNotificationStyle();
        IPay payStyle = order.createPayStyle();
        //Override metotları yardımıyla ödeme ve bildirim işlemleri yapılır.
        notificationStyle.sendMessage("Ödeme gerçekleştirildi.");
        payStyle.pay(200);


        Log.d("Design Patterns", "*****************************************************************");
        //Prototype design pattern
        //Picture nesnesini constructor yardımıyla oluşturuyoruz
        Picture picture = new Picture("Kırmızı", 20, 20);
        //Yeni bir picture nesnesi oluşturup ilk oluşturudğumuz picture nesnesinin
        //kopyasını bu picture nesnesine atıyoruz.
        Picture copyPicture = picture.getCopy();
        Log.d("Prototype => ", "Kopyalanan resim nesnesi; " + copyPicture.toString());


        Log.d("Design Patterns", "*****************************************************************");
        //Builder design pattern
        //Computer nesnesi builder yardımıyla tanımlanıyor.
        //Bu tanımlamayı yaparken öncelikle ComputerBuilder sınıfının constructor' ı için gerekli
        //olan parametreler verilir. Daha sonra isteğe göre ComputerBuilder sınıfının diğer metotları
        //kullanılarak oluşturulan enseneye ek datalar kaydedilebilir. Son olarak yine bu sınıfın içinde
        //bulunan build() metodu ile oluşan computer nesnesinin son hali Computer nesnesi olarak return edilir.
        Computer computer = new Computer.ComputerBuilder("1 TB","4 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();


        Log.d("Builder => ", "HDD: " + computer.getHDD() + " RAM: " + computer.getRAM()
                + " Graphics Card: " + computer.isGraphicsCardEnabled() + " Bluetooth: " + computer.isBluetoothEnabled());


        Log.d("Design Patterns", "*****************************************************************");
        //Adapter design pattern
        //Örnek bir customer nesnesi oluşturulur.
        Customer customer = new Customer("012345", "test description", "ESENTEPE/ŞİŞLİ", "İSTANBUL", "TÜRKİYE");
        //customer nesnesinin adaptörü oluşturulur.
        CustomerBillAddressAdapter addressAdapter = new CustomerBillAddressAdapter(customer);
        //customer sınıfı customerAdapter sayesinde bir address nesnesi olur.
        //Atama gerçekleştirilir.
        Address address = addressAdapter;

        Log.d("Adapter => ", "Adres: " + address.getAllAddress());
        Log.d("Adapter => ", "Şehir: " + address.getCity());
        Log.d("Adapter => ", "Ülke: " + address.getCountry());


        Log.d("Design Patterns", "*****************************************************************");
        //Composite design pattern
        //Ekip üyeleri oluşturulur.
        TeamMember teamMember1 = new TeamMember("Name1", "Surname1");
        TeamMember teamMember2 = new TeamMember("Name2", "Surname2");
        TeamMember teamMember3 = new TeamMember("Name3", "Surname3");
        TeamMember teamMember4 = new TeamMember("Name4", "Surname4");
        TeamMember teamMember5 = new TeamMember("Name5", "Surname5");
        //Ekip liderleri oluşturulur.
        TeamManager teamManager1 = new TeamManager("Manager Name1");
        TeamManager teamManager2 = new TeamManager("Manager Name2");
        TeamManager teamManager3 = new TeamManager("Manager Name3");
        //Ekip liderlerinin altına ekip üyeleri eklenir.
        //teamManager1 ve teamManager2 ekip liderleri teamManager3 yöneticisinin altındadır.
        teamManager1.addMember(teamMember1);
        teamManager1.addMember(teamMember2);
        teamManager2.addMember(teamMember3);
        teamManager2.addMember(teamMember4);
        teamManager2.addMember(teamMember5);
        //teamManager3 ekip lideri en üstteki yöneticidir.
        teamManager3.addMember(teamManager1);
        teamManager3.addMember(teamManager2);
        //teamManager2 altındaki ekip üyeri yazdırılır.
        teamManager2.printData();
        Log.d("Composite", "------------------------------------------------------------------");
        //teamManager3 yöneticisi altındaki yani tüm ekip üyeleri yazdırılır.
        teamManager3.printData();


        Log.d("Design Patterns", "*****************************************************************");
        //Decorator design pattern
        //Basit bir telefon oluşturuldu. Burada basit telefon bir telefonda bulunacak default özelliklerin
        //olduğu bir telefondru. Class yapısı buna göre dizayn edilmiştir.
        Phone simplePhone = new SimplePhone();
        //Eğer kameralı bir telefon elde etmek istersek bu basit telefonu kullanarız.
        //Çünkü kamaeralı telefon sınıfı parametre olrak bir basit telefon nesnesi almalıdır.
        Phone cameraPhone = new CameraPhoneDecorator(simplePhone);
        //Aynı zamanda aşağıdaki gibi bir tanımlama yaparak da tek seferde, ekstra bir basit telefon
        //nesnesi oluşturulmadan, kameralı ve mms özellikli telefonu oluşturabiliriz.
        Phone superPhone = new MMSPhoneDecorator(new CameraPhoneDecorator(new SimplePhone()));

        simplePhone.createPhone();
        Log.d("Decorator => ", "-------------------------");
        cameraPhone.createPhone();
        Log.d("Decorator => ", "-------------------------");
        superPhone.createPhone();


        Log.d("Design Patterns", "*****************************************************************");
        //Flyweight design pattern
        String line = "Selamun aleyküm dünya!";

        CharacterCreator characterCreator = new CharacterCreator();

        for(char c : line.toCharArray()){
            Character character = characterCreator.getCharacter(c);
            character.printChar();
        }


        Log.d("Design Patterns", "*****************************************************************");
        //Facade design pattern
        //Computer sınıfından bir nesne oluşturulur.
        com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.facade.Computer computer1 = new com.example.mehmetozdemir.designpatterns.StructuralDesignPatterns.facade.Computer();
        //Sadece  computer sınıfı içindeki openComputer metodunu kullanıyoruz.
        //openComputer metodu içinde işlemci, sabit disk ve ram ile ilgili işlemler yapılır.
        //Ancak burada biz bu işlemleri görmeden computer1 nesnesini çalışır hale geçirebiliyoruz.
        computer1.openComputer();


        Log.d("Design Patterns", "*****************************************************************");
        //Mediator design pattern
        //DeviceMediator sınıfında bir arabulucu nesne tanımladık.
        DeviceMediator deviceMediator = new DeviceMediator();
        //Elektronik cihazları yukarıda örneklediğimiz arabulucu nesnesini parametre vererek tanımladık.
        //Bu sayede bu cihazlar arasında meadiator nesne sayesinde bir iletişim olur.
        //Burada dikkat edilmesi gereken DeviceMediator sınıfının yapısıyla ilgili olarak aşağıdaki 3 elektronik
        //cihaz olmadan(mediator a 3 elektronik cihazı tanımlamadan) herhangi bir işlem yapılmamasıdır.
        //Çünkü işlem yapıldığında atama olmadığı için null pointer hatası alınacaktır.
        ElectronicDevice computer2 = new com.example.mehmetozdemir.designpatterns.BehavioralDesignPatterns.mediator.Computer(deviceMediator);
        ElectronicDevice television = new Television(deviceMediator);
        ElectronicDevice radio = new Radio(deviceMediator);

        //Burada cihazların start metodu kullanılarak hem ilgili cihaz çalıştırılır hem de diğer elektronik
        //cihazlar kapatılır. Çünkü herbir cihazın start metodunda DeviceMediator üzerindeki ilgili cihazın start
        //metodu da çağırılır. Bu metotta da(DeviceMediator daki start metodu) ilgili diğer tüm elektronik
        //cihazların stop metodları çağırılır. Böylelikle başta anlatılan yapı elde edilmiş olur.
        computer2.start();
        //Bu şekilde bir cihazın çalışmasını durdurursak sadece ilgili cihaz durur. Çünkü ilgili cihazın
        //stop metodu içinde DeviceMeditor üzerinden herhangi bir işlem yapılmaz. Böylelikle işlem sonucundan
        //sadeece ilgili elektronik cihaz etkilenir.
        television.stop();


        Log.d("Design Patterns", "*****************************************************************");
        //State design pattern
        //Yeni bir banka hesabı tanımlanıyor.
        //BankAccount sınıfının kurucu metodunda oluşturulan hesap normal banka hesabı olarak açılıyor.
        //Bu default olarak yapılan bir işlemdir.
        BankAccount bankAccount = new BankAccount();
        //Bu banka hesabı üzerinden para ödeme ve çekme işlemleri alttaki metotlarla yapılıyor.
        //Hesap normal banka hesabı olduğu için işlemler buna göre yapılıyor.
        bankAccount.payMoney();
        bankAccount.pullMoney();
        //Oluşturulan bu banka hesabının hesap türü çalışma anında değiştiriliyor.
        //Hesabın yeni türü döviz hesabı olarak değiştiriliyor.
        bankAccount.changeBankAccountState(new ForeignCurrencyBankAccount());
        //Daha sonra yapılan tüm işlemler bu hesap türüne göre(döviz hesabı) yapılıyor.
        bankAccount.payMoney();
        bankAccount.pullMoney();



        Log.d("Design Patterns", "*****************************************************************");
        //Observer design pattern
        //Yeni bir fiyat konusu örnekledik
        PriceTopic priceTopic = new PriceTopic("Samsung Galaxy S5");
        //2 tane ayrı müşteri tiplerinde müşteriler örnekledik.
        CustomerType1 customerType1 = new CustomerType1("Mehmet");
        CustomerType2 customerType2 = new CustomerType2("Ahmet");
        //Yukarıda örneklediğimiz fiyat konusuna yine yukarıda örneklediğimiz müşterileri
        //bu fiyat konusunu izleyen müşteriler olarak ekledik.
        //Artık yapılan değişimlerden fiyat konusuna dahil olan müşteriler hemen haberdar olabilecek.
        priceTopic.addObserver(customerType1);
        priceTopic.addObserver(customerType2);
        //Fiyatı değişitrdiğmizde veya direk müşterileri haber ver(giveNoticeObservers) metodu ile
        //konuya bağlı bulunan müşterilere(gözlemcilere) haber verdik.
        priceTopic.changePrice(1500);



        Log.d("Design Patterns", "*****************************************************************");
        //Memento design pattern
        //Yeni bir döküman nesnesi oluşturuyoruz
        Document document = new Document();
        //Bu dökümana içerik atıyoruz.
        document.assignContent("First entry");
        //Daha sonra bir dokuman yazıcısı tanımlıyoruz ve yukarıda oluşturuduğumuz dokümanı parametre olarak veriyoruz.
        DocumentWriter documentWriter = new DocumentWriter(document);
        //Bu döküman yazıcısıyla yazdığımız içerikler yukarıdaki dökümana aktarılır.
        documentWriter.writeDocument("Second entry");
        documentWriter.writeDocument("Third entry");
        documentWriter.writeDocument("Fourth entry");
        documentWriter.writeDocument("Fifth entry");
        //döküman içerisindeki son içeriği yazdırıyoruz.
        Log.d("Memento => ", "Dokümandaki son içerik: " + document.getContent());
        //Döküman yazıcısı ve onun içindeki döküman hatırlayıcısı yardımıyla geri al işlemleri
        //yaparak önceki içeriklere ulaşıyoruz.
        documentWriter.getBack();
        documentWriter.getBack();
        Log.d("Memento => ", "2 öğe dokümandan çıkarıldıktan sonra dokümandaki son içerik: " + document.getContent());



        Log.d("Design Patterns", "*****************************************************************");
        //Template Method design pattern
        //Birer tane çorba ve pilav yapıcı nesnesi örneklendiriliyor.
        Cooker cooker1 = new SoupMaker();
        Cooker cooker2 = new RiceMaker();
        //Cooker sınıfındaki makeEat metodu yardımıyla arka planda neler yapıldığını bilmeden
        //ilgili yemeğin yapılması sağlanıyor.
        //Facade design pattern a benziyor gibi durmasına karşılık.
        //Facade design pattern da bir sınıf vardı ve bu sınıfta o sınıfın alt nesneleri vardı.
        //Bu alt nesnelerin kendilerine ait method ve değişkenleri vardı.
        //Bu metodlar ve/veya değişkenler ana sınıfta kullanılıyordu.
        //Ana sınıfın çağırıldığı yerde tek bir metod veya sadece ana sınıfın metdoları ile tüm
        //sistem harekete geçiriliyordu.
        //Template Method da ise soyut bir sınıf ve bu sınıfın soyut metodları vardır.
        //Bu soyut sınıfı kalıtım alan tüm sınıflar için tüm sistemi çalıştıracak ortak
        //bir metot bulunmaktadır.
        cooker1.makeEat();
        Log.d("Template Method => ", "--------------------------------------");
        cooker2.makeEat();



        Log.d("Design Patterns", "*****************************************************************");
        //Command design pattern
        //Bir lamba nesnesi oluşturuluyor.
        Lamp lamp = new Lamp();
        //Bu lamba nesnesi ile lamba açma ve lamba kapatma nesneleri oluşturuluyor.
        LampOpenCommand lampOpenCommand = new LampOpenCommand(lamp);
        LampCloseCommand lampCloseCommand = new LampCloseCommand(lamp);
        //Lamba açma ve lamba kapatma nesneleri ile lamba butonu nesnesi oluşturuluyor.
        //Birden fazla nesne bu nesne üzerinde birleştiriliyor.
        //Bu sınıf üzerinden işlemler yapılıyor.
        LampButtons lampButtons = new LampButtons(lampOpenCommand, lampCloseCommand);
        //Lamba butonu nesnesi üzerinden lambaya erişim sağlanıyor.
        lampButtons.openLamp();
        lampButtons.closeLamp();



        Log.d("Design Patterns", "*****************************************************************");
        //Chain of Responsibility design pattern
        //Function tanımlamaları yapılıyor.
        Function function1, function2;
        //Function' a işlev ataması yapılıyor ve daha sonra bağlı listeye benzer bir yapıda
        //ancak bağlı listedeki gibi nesne adreslerini tutmayarak nesnelerin kendilerini
        //her bir nesnenin içinde saklayarak işlevler ard arda ekleniyor.
        function1 = new FunctionA();
        function2 = function1.setNextFunction(new FunctionC());
        function2 = function2.setNextFunction(new FunctionA());
        function2 = function2.setNextFunction(new FunctionB());
        function2 = function2.setNextFunction(new FunctionA());
        function2 = function2.setNextFunction(new Function() {
            @Override
            protected void doFunction(String functionData) {
                Log.d("CofR => ", functionData + " verisi çalışma anında oluşturulan" +
                        "\ntek sefer kullanılabilecek sınıf yapısı ile gerçekleştirildi.");
            }
        });
        //run metodu ile birbirne bağlanmış tüm işlevler çalıştırılıyor.
        function1.run("Test data");


        Log.d("Design Patterns", "*****************************************************************");
        //Strategy design pattern
        LoanShark loanShark1 = new LoanShark(new MethodA());
        LoanShark loanShark2 = new LoanShark(new MethodB());

        loanShark1.calculateDebt();
        loanShark2.calculateDebt();


        Log.d("Design Patterns", "*****************************************************************");
        //Interpreter design pattern
        String text = "+--%%+";
        List<Symbol> symbols = new ArrayList<>();

        for (char c : text.toCharArray()){
            if(c == '+')
                symbols.add(new PlusSymbol());
            else if(c == '-')
                symbols.add(new MinusSymbol());
            else if(c == '%')
                symbols.add(new PercentSymbol());
        }

        for (Symbol s : symbols)
            s.interpretSymbol();
    }
}

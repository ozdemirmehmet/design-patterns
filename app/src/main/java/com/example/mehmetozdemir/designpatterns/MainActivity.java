package com.example.mehmetozdemir.designpatterns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mehmetozdemir.designpatterns.Behavioral.mediator.DeviceMediator;
import com.example.mehmetozdemir.designpatterns.Behavioral.mediator.ElectronicDevice;
import com.example.mehmetozdemir.designpatterns.Behavioral.mediator.Radio;
import com.example.mehmetozdemir.designpatterns.Behavioral.mediator.Television;
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
        ElectronicDevice computer2 = new com.example.mehmetozdemir.designpatterns.Behavioral.mediator.Computer(deviceMediator);
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
    }
}

package com.example.mehmetozdemir.designpatterns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mehmetozdemir.designpatterns.Creational.abstractFactory.FastOrderSelector;
import com.example.mehmetozdemir.designpatterns.Creational.abstractFactory.INotification;
import com.example.mehmetozdemir.designpatterns.Creational.abstractFactory.IOrder;
import com.example.mehmetozdemir.designpatterns.Creational.abstractFactory.IPay;
import com.example.mehmetozdemir.designpatterns.Creational.abstractFactory.NormalOrderSelector;
import com.example.mehmetozdemir.designpatterns.Creational.builder.Computer;
import com.example.mehmetozdemir.designpatterns.Creational.factoryMethod.IPictureFormat;
import com.example.mehmetozdemir.designpatterns.Creational.factoryMethod.FormatSelector;
import com.example.mehmetozdemir.designpatterns.Creational.prototype.Picture;
import com.example.mehmetozdemir.designpatterns.Creational.singleton.TestObject;
import com.example.mehmetozdemir.designpatterns.Structural.adapter.Address;
import com.example.mehmetozdemir.designpatterns.Structural.adapter.Customer;
import com.example.mehmetozdemir.designpatterns.Structural.adapter.CustomerBillAddressAdapter;
import com.example.mehmetozdemir.designpatterns.Structural.composite.TeamManager;
import com.example.mehmetozdemir.designpatterns.Structural.composite.TeamMember;
import com.example.mehmetozdemir.designpatterns.Structural.decorator.CameraPhoneDecorator;
import com.example.mehmetozdemir.designpatterns.Structural.decorator.MMSPhoneDecorator;
import com.example.mehmetozdemir.designpatterns.Structural.decorator.Phone;
import com.example.mehmetozdemir.designpatterns.Structural.decorator.SimplePhone;
import com.example.mehmetozdemir.designpatterns.Structural.flyweight.Character;
import com.example.mehmetozdemir.designpatterns.Structural.flyweight.CharacterCreator;

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
    }
}

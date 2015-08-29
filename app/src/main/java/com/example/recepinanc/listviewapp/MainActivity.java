package com.example.recepinanc.listviewapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements GameListFragment.Communicator {
    private FragmentManager fm;
    private GameListFragment gameListFragment;
    private GameDetailFragment2 gameDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * TODO:
         * Uygulamayı açtın, kullandın bir süre, whatsapptan mesaj geldi uygulamayı kapatmadan
         * whatsapa baktın. Uygulama onPause methodunu çalıştırır sonra background'da bekler
         * kapanmaz. Uzun bir süre geçerse aradan sen diğer uygulamalara bakarken senin uygualaman
         * kapatılabilir. Bu durumda yine onCreate methodun çağrılır. Ama uygulama daha önceden açık
         * olduğu için sen burda kontrol etmeden direk fragment'ı eklersen üst üste iki tane fragment
         * eklemiş oluyorsun. Activity lifecycle olayını tekrar gözden geçir. Metin bulamadım şimdi
         * ama şöyle bir image var: https://softclipboard.files.wordpress.com/2015/08/u3shm.png
         *
         * Senin fragment soruna bu açıklama cevap olacak sanırım. Burda fragmentManager'da fragment
         * var mı diye kontrol etmek de aynı amaçlı(android-nerd). Ama bu olay için asıl savedInstanceState
         * kullanılır.
         */
        if (savedInstanceState == null) {
            gameListFragment = new GameListFragment();
            fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.container, gameListFragment);
            transaction.commit();
        }

    }


    @Override
    public void passGameData(String data1, int data) {
        /**
         * TODO
         * setGame methodu yerine vereceğin değerleri Fragment'a argüman olarak vermen
         * daha doğru olur. method olarak verdiğinde Fragment'in bütün viewları oluşturulduktan
         * sonra o method çalışıyor. View oluşturuluyor, sonra tekrar değiştilmiş oluyor.
         *
         * GameDetailFragment2 diye bir örnek Fragment oluşturdum. Factory pattern ile oluşturursan
         * fragmentı ilerde esneklik sağlar. Fragment'ın "setArgumant" methodunu da kullanabilirsin direk.
         */
        gameDetailFragment = GameDetailFragment2.newInstance(data1, data);
        //gameDetailFragment = new GameDetailFragment();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container, gameDetailFragment);
        transaction.commit();
        //gameDetailFragment.setGame(data1, data)
    }

    @Override
    public void onBackPressed() {
        /**
         * TODO:
         * Geri tuşuna basıldığında kullanıcı oyun detay sayfasındayda liste sayfasına geri
         * yollanıyor.
         */
        if (gameDetailFragment != null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.container, gameListFragment);
            transaction.commit();
            gameDetailFragment = null;
            return;
        }
        super.onBackPressed();
    }
}

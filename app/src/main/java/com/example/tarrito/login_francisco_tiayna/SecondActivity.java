package com.example.tarrito.login_francisco_tiayna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import com.example.tarrito.login_francisco_tiayna.R;
import com.example.tarrito.login_francisco_tiayna.MyAdapter;
import com.example.tarrito.login_francisco_tiayna.Trabajador;

import java.util.List;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import android.widget.Button;
import android.widget.RadioGroup;

public class SecondActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Trabajador>>{

    private ListView listView;
    private MyAdapter adapter;
    private String usuariox;
    private String passwordx;
    private Realm realm;
    private RealmResults<Trabajador> trabajadors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        usuariox = getIntent().getStringExtra("editTextUsuario");
        passwordx = getIntent().getStringExtra("editTextPassword");

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        listView = (ListView) findViewById(R.id.listView);

        trabajadors = getAllTrabajador();
        trabajadors.addChangeListener(this);

        adapter = new MyAdapter(trabajadors,R.layout.list_item_view, this);

        listView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Trabajador> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    private RealmResults<Trabajador> getAllTrabajador() {
        return realm.where(Trabajador.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                Trabajador p1 = new Trabajador("juanito", "123456789", "11111-1", "23", "calle siempre viva 555", "12345678", "gerente");
                Trabajador p2 = new Trabajador("juanito", "123456789", "11111-1", "23", "calle siempre viva 555", "12345678", "gerente");
                Trabajador p3 = new Trabajador("juanito", "123456789", "11111-1", "23", "calle siempre viva 555", "12345678", "gerente");


                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);

                trabajadors = getAllTrabajador();
            }
        });
    }

}

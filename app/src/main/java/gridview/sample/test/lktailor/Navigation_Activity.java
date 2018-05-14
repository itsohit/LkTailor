package gridview.sample.test.lktailor;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Navigation_Activity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
//     MyExpandableAdapter adapter;
      DrawerLayout drawer;
     LinearLayout product,trip,stylebook,fabric,gallary,how_to_measure,eorder,customerservice,tailoring,
                testimonal,company;
    TextView title_toolbar;
    RelativeLayout relativelayout_navigation;
//        ArrayList<String> header;
//        HashMap<String,List<String>> list;
      NavigationView navigationView;
//     ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
           navigationView = (NavigationView) findViewById(R.id.navigation_bar);
            drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//                expandableListView = (ExpandableListView) findViewById(R.id.expandable_list);
            product = (LinearLayout) findViewById(R.id.linear_product);
            trip = (LinearLayout) findViewById(R.id.linear_trip_schedul);
            fabric = (LinearLayout) findViewById(R.id.linear_fabric);
            gallary = (LinearLayout) findViewById(R.id.linear_gallary);
            how_to_measure = (LinearLayout) findViewById(R.id.linear_how_to_measure);
            eorder = (LinearLayout) findViewById(R.id.linear_eorder);
            customerservice = (LinearLayout) findViewById(R.id.linear_customerservice);
            tailoring = (LinearLayout) findViewById(R.id.linear_tailoring);
            testimonal = (LinearLayout) findViewById(R.id.linear_testmional);
            company = (LinearLayout) findViewById(R.id.linear_company);
            relativelayout_navigation = (RelativeLayout) findViewById(R.id.navigation_relativelayout);
              title_toolbar = (TextView) findViewById(R.id.title_toolbar);

            product.setOnClickListener(this);
            trip.setOnClickListener(this);
            fabric.setOnClickListener(this);
            gallary.setOnClickListener(this);
            how_to_measure.setOnClickListener(this);
            eorder.setOnClickListener(this);
            customerservice.setOnClickListener(this);
            tailoring.setOnClickListener(this);
            testimonal.setOnClickListener(this);
            company.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // Set paddingTop of toolbar to height of status bar.
            // Fixes statusbar covers toolbar issue
    //        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        }

           toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle option = new ActionBarDrawerToggle(Navigation_Activity.this,drawer,toolbar,R.string.open,R.string.close);
        drawer.setDrawerListener(option);
        option.syncState();
           navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                      relativelayout_navigation.setVisibility(View.GONE);
                   drawer.closeDrawer(GravityCompat.START);
                    toolbar.setTitle("");
                   switch (item.getItemId()){
                         case R.id.menu_product:
                             title_toolbar.setText("");
                             Product pro = new Product();
                             FragmentManager fragmentManager = getSupportFragmentManager();
                             FragmentTransaction transaction= fragmentManager.beginTransaction();
                             transaction.replace(R.id.fragment_all,pro).commit();
                               break;
                         case R.id.menu_stylebook:
                              title_toolbar.setText("Style Book");
                              style_book style = new style_book();
                                FragmentManager fm = getSupportFragmentManager();
                               FragmentTransaction trans = fm.beginTransaction();
                               trans.replace(R.id.fragment_all,style).commit();
                                break;
                         case R.id.menu_aboutus:
                               title_toolbar.setText("About Us");
                                    Aboutus aboutus = new Aboutus();
                                       FragmentManager fragmentManager1 = getSupportFragmentManager();
                                 FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
                                 transaction1.replace(R.id.fragment_all,aboutus).commit();
                               break;
                       case R.id.menu_gallary:
                              title_toolbar.setText("Gallary");
                             Gallary gallary = new Gallary();
                               FragmentManager f2 = getSupportFragmentManager();
                               FragmentTransaction transaction2 = f2.beginTransaction();
                              transaction2.replace(R.id.fragment_all,gallary).commit();
                              break;
                       case R.id.menu_customer_service:
                           title_toolbar.setText("Customer Service");
                           CustomerSerivce customerSerivce = new CustomerSerivce();
                           FragmentManager f3 = getSupportFragmentManager();
                           FragmentTransaction transaction3 = f3.beginTransaction();
                           transaction3.replace(R.id.fragment_all,customerSerivce).commit();
                             break;
                       case R.id.menu_customer:
                            title_toolbar.setText("");
                           Customer customer = new Customer();
                              FragmentManager f4 =  getSupportFragmentManager();
                              FragmentTransaction transaction4 = f4.beginTransaction();
                             transaction4.replace(R.id.fragment_all,customer).commit();
                              break;
                       case R.id.menu_tailoring:
                           title_toolbar.setText("Tailoring");
                           Tailoring tail = new Tailoring();
                           FragmentManager f5 =  getSupportFragmentManager();
                           FragmentTransaction transaction5 = f5.beginTransaction();
                           transaction5.replace(R.id.fragment_all,tail).commit();
                             break;
                       case R.id.menu_measurement:
                           title_toolbar.setText("Measurement");
                           Measurement measur = new Measurement();
                           FragmentManager f6 =  getSupportFragmentManager();
                           FragmentTransaction transaction6 = f6.beginTransaction();
                           transaction6.replace(R.id.fragment_all,measur).commit();
                             break;
                       case R.id.menu_stylefile:
                           title_toolbar.setText("Style File");
                           Style_File style_file = new Style_File();
                           FragmentManager f7 =  getSupportFragmentManager();
                           FragmentTransaction transaction7 = f7.beginTransaction();
                           transaction7.replace(R.id.fragment_all,style_file).commit();
                             break;
                       case R.id.menu_contactus:
                           title_toolbar.setText("CONTACT US");
                           ContactUs contact = new ContactUs();
                           FragmentManager f8 =  getSupportFragmentManager();
                           FragmentTransaction transaction8 = f8.beginTransaction();
                           transaction8.replace(R.id.fragment_all,contact).commit();
                             break;
                       case R.id.menu_fabric_page:
                           title_toolbar.setText("fabric page");
                           Fabric_Page fabric = new Fabric_Page();
                           FragmentManager f9 =  getSupportFragmentManager();
                           FragmentTransaction transaction9 = f9.beginTransaction();
                           transaction9.replace(R.id.fragment_all,fabric).commit();
                           break;
                       case R.id.menu_testimonail:
                           title_toolbar.setText("testimonial");
                            Testimonal_Fragment test = new Testimonal_Fragment();
                           FragmentManager f10 =  getSupportFragmentManager();
                           FragmentTransaction transaction10 = f10.beginTransaction();
                           transaction10.replace(R.id.fragment_all,test).commit();
                           break;
                       case R.id.menu_how_to_measure:
                           title_toolbar.setText("how to measure");
                             How_to_measurement howto = new How_to_measurement();
                           FragmentManager f11 =  getSupportFragmentManager();
                           FragmentTransaction transaction11 = f11.beginTransaction();
                           transaction11.replace(R.id.fragment_all,howto).commit();
                           break;
//                       case R.id.menu_arrayoffabric:
//                           title_toolbar.setText("");
//                                ArrayOfImage array = new ArrayOfImage();
//                           FragmentManager f12 =  getSupportFragmentManager();
//                           FragmentTransaction transaction12 = f12.beginTransaction();
//                           transaction12.replace(R.id.fragment_all,array).commit();
//                           break;
//                       case R.id.menu_login:
//                            Intent i = new Intent(Navigation_Activity.this,Login_Activity.class);
//                              startActivity(i);
//                             break;
//                       case R.id.menu_registration:
//                           Intent ii = new Intent(Navigation_Activity.this,Register_Activity.class);
//                           startActivity(ii);
//                           break;
                       case R.id.menu_logout:
                           Intent iout = new Intent(Navigation_Activity.this,Login_Activity.class);
                           startActivity(iout);
                           break;
                       default:
                     }
                   return true;
               }
           });

//        datastore();
//        adapter = new MyExpandableAdapter(this,header,list);
//        expandableListView.setAdapter(adapter);
//            expandableListView.setOnChildClickListener(this);

     }

//    public int getStatusBarHeight() {
//        int result = 0;
//        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
//        if (resourceId > 0) {
//            result = getResources().getDimensionPixelSize(resourceId);
//        }
//        return result;
//    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.END))
             drawer.closeDrawer(GravityCompat.START);
        else
            drawer.closeDrawer(GravityCompat.START);
    }

//    void datastore(){
//           header = new ArrayList<String>();
//            list = new HashMap<String,List<String>>();
//
//             header.add("Home");
//             header.add("Product");
//             header.add("Trip shedule");
//             header.add("Style Book");
//             header.add("Fabric");
//             header.add("Gallary");
//             header.add("How to Measure");
//             header.add("E-Order");
//             header.add("Customer Service");
//             header.add("Tailoring");
//             header.add("Testimonals");
//             header.add("Company");
//
//          List<String> Home = new ArrayList<String>();
//                Home.add("A");
//                Home.add("B");
//                Home.add("C");
//                Home.add("D");
//                Home.add("E");
//                Home.add("F");
//                Home.add("G");
//
//          List<String> Product = new ArrayList<String>();
//          Product.add("A");
//          Product.add("B");
//          Product.add("C");
//          Product.add("D");
//          Product.add("E");
//          Product.add("F");
//          List<String> Trip = new ArrayList<String>();
//          Trip.add("A");
//          Trip.add("B");
//          Trip.add("C");
//          Trip.add("D");
//          Trip.add("E");
//          Trip.add("F");
//          Trip.add("G");
//          List<String> stylebook = new ArrayList<String>();
//          stylebook.add("A");
//          stylebook.add("B");
//          stylebook.add("C");
//          stylebook.add("D");
//          stylebook.add("E");
//          stylebook.add("F");
//          stylebook.add("G");
//          List<String> fabric = new ArrayList<String>();
//          fabric.add("A");
//          fabric.add("B");
//          fabric.add("C");
//          fabric.add("D");
//          fabric.add("E");
//          fabric.add("F");
//          List<String> gallary = new ArrayList<String>();
//          gallary.add("A");
//          gallary.add("B");
//          gallary.add("C");
//          gallary.add("D");
//          gallary.add("E");
//          gallary.add("F");
//          gallary.add("G");
//          List<String> howtomeasure = new ArrayList<String>();
//          howtomeasure.add("A");
//          howtomeasure.add("B");
//          howtomeasure.add("C");
//          howtomeasure.add("D");
//          howtomeasure.add("E");
//          howtomeasure.add("F");
//          howtomeasure.add("G");
//
//          List<String> eorder = new ArrayList<String>();
//          eorder.add("A");
//          eorder.add("B");
//          eorder.add("C");
//          eorder.add("D");
//          eorder.add("E");
//          eorder.add("F");
//          eorder.add("G");
//          List<String> customerservice = new ArrayList<String>();
//          customerservice.add("A");
//          customerservice.add("B");
//          customerservice.add("C");
//          customerservice.add("D");
//          customerservice.add("E");
//          customerservice.add("F");
//          List<String> tailoring = new ArrayList<String>();
//          tailoring.add("A");
//          tailoring.add("B");
//          tailoring.add("C");
//          tailoring.add("D");
//          tailoring.add("E");
//          tailoring.add("F");
//          tailoring.add("G");
//          List<String> testimonal = new ArrayList<String>();
//          testimonal.add("A");
//          testimonal.add("B");
//          testimonal.add("C");
//          testimonal.add("D");
//          testimonal.add("E");
//          testimonal.add("F");
//          List<String> Company = new ArrayList<String>();
//          Company.add("A");
//          Company.add("B");
//          Company.add("C");
//          Company.add("D");
//          Company.add("E");
//
//            list.put(header.get(0),Home);
//            list.put(header.get(1),Product);
//            list.put(header.get(2),Trip);
//            list.put(header.get(3),stylebook);
//            list.put(header.get(4),fabric);
//            list.put(header.get(5),gallary);
//            list.put(header.get(6),howtomeasure);
//            list.put(header.get(7),eorder);
//            list.put(header.get(8),customerservice);
//            list.put(header.get(9),tailoring);
//            list.put(header.get(10),testimonal);
//            list.put(header.get(11),Company);
//
//      }

    @Override
    public void onClick(View v) {
        relativelayout_navigation.setVisibility(View.GONE);
        switch(v.getId()){
            case R.id.linear_product:
                title_toolbar.setText("");
                Product pro = new Product();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction= fragmentManager.beginTransaction();
                  transaction.replace(R.id.fragment_all,pro).commit();
                    break;
            case R.id.linear_stylebook:
                title_toolbar.setText("Style Book");
                style_book style = new style_book();
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction transaction1= fragmentManager1.beginTransaction();
                transaction1.replace(R.id.fragment_all,style).commit();
                break;

            case R.id.linear_fabric:
                  title_toolbar.setText("Fabric page");
                Fabric_Page fabric = new Fabric_Page();
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction transaction2= fragmentManager2.beginTransaction();
                transaction2.replace(R.id.fragment_all,fabric).commit();
                break;

            case R.id.linear_gallary:
                title_toolbar.setText("gallary");
                 Gallary gallary = new Gallary();
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction transaction3= fragmentManager3.beginTransaction();
                transaction3.replace(R.id.fragment_all,gallary).commit();
                break;

            case R.id.linear_how_to_measure:
                   title_toolbar.setText("How to measure");
                 How_to_measurement how = new How_to_measurement();
                FragmentManager fragmentManager4 = getSupportFragmentManager();
                FragmentTransaction transaction4= fragmentManager4.beginTransaction();
                transaction4.replace(R.id.fragment_all,how).commit();
                break;
            case R.id.linear_customerservice:
                   title_toolbar.setText("Customer service");
                    CustomerSerivce service = new CustomerSerivce();
                FragmentManager fragmentManager5 = getSupportFragmentManager();
                FragmentTransaction transaction5= fragmentManager5.beginTransaction();
                transaction5.replace(R.id.fragment_all,service).commit();
                break;
            case R.id.linear_tailoring:
                  title_toolbar.setText("Tailoring");
                  Tailoring tail = new Tailoring();
                FragmentManager fragmentManager6 = getSupportFragmentManager();
                FragmentTransaction transaction6= fragmentManager6.beginTransaction();
                transaction6.replace(R.id.fragment_all,tail).commit();
                break;
            case R.id.linear_testmional:
                title_toolbar.setText("Testmional");
                   Testimonal_Fragment test = new Testimonal_Fragment();
                FragmentManager fragmentManager7 = getSupportFragmentManager();
                FragmentTransaction transaction7= fragmentManager7.beginTransaction();
                transaction7.replace(R.id.fragment_all,test).commit();
                break;
            default:
        }
    }
//
//    @Override
//    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//        drawer.closeDrawer(GravityCompat.START);
//         relativelayout_navigation.setVisibility(View.GONE);
//        switch(groupPosition){
//            case 0:
//                if(childPosition==0){
//                    Intent intent = new Intent(Navigation_Activity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//            case 1:
//                if(childPosition==0){
//                    Product p = new Product();
//                    FragmentManager fragment = getSupportFragmentManager();
//                    FragmentTransaction transaction= fragment.beginTransaction();
//                    transaction.replace(R.id.fragment_all,p,null).commit();
//                }
//            case 3:
//                if (childPosition == 0) {
//                    style_book style = new style_book();
//                    FragmentManager fragment = getSupportFragmentManager();
//                    FragmentTransaction transaction = fragment.beginTransaction();
//                    transaction.replace(R.id.fragment_all, style, null).commit();
//                }
//                default:
//        }
//        return true;
//    }
}

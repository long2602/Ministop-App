package com.example.projetct_mb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetct_mb.R;
import com.example.projetct_mb.db.DBhelper;
import com.example.projetct_mb.model.*;

public class MainActivity extends AppCompatActivity {
    static public DBhelper dBhelper;
    EditText edituser,editpass;
    Button btnLogin;
    TextView txtdangki,txtquen;
    static public customer IDUSER;
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        LoadData();
        EventDangNhap();
    }
    public void LoadData(){
        dBhelper=new DBhelper(this);
//        dBhelper.deleteBill(1);
//        dBhelper.deleteBill(2);
        //
//        //load dữ liệu cho type
//        dBhelper.addType(new type("SANDWICH","https://cdn.tgdd.vn/Files/2020/05/26/1258341/nhung-cach-che-bien-banh-mi-sandwich-nhanh-chong-t-12-760x367.jpg"));
//        dBhelper.addType(new type("NƯỚC GIẢI KHÁT","https://trungtamnghiencuuthucpham.vn/wp-content/uploads/2016/11/Nuocgiaikhat.jpg"));
//        dBhelper.addType(new type("SUSHI","https://inhat.vn/ha-noi/wp-content/uploads/2019/08/nha-hang-sushi-o-ha-noi-ava.jpg"));
//        dBhelper.addType(new type("TRÁNG MIỆNG","https://wiki-travel.com.vn/Uploads/Post/myyen97-192727022703-mon-trang-mieng.jpg"));
//        dBhelper.addType(new type("ODEN","https://assets-a1.kompasiana.com/items/album/2019/07/09/jpinfo-5d240987097f36771255dbf2.jpg"));
//        dBhelper.addType(new type("THỨC ĂN NHANH","https://cdn.tgdd.vn/Files/2020/12/16/1314124/thuc-an-nhanh-la-gi-an-thuc-an-nhanh-co-tot-hay-khong-202012161146006756.jpg"));
//        //
//        //load dữ liệu sản phẩm
//        dBhelper.addProduct(new product("SANDWICH THỊT XÔNG KHÓI & TRỨNG",27000,"https://www.ministop.vn/img/product/detail/60a393c446e39_1b4b46a732d80c0d549b9fc9e40e9a1a.jpg",
//                "MINISTOP vừa mới cho “ra lò” một loại Sandwich cực gây mê: SANDWICH THỊT XÔNG KHÓI & TRỨNG.\n" +
//                        "Thịt xông khói sốt guchujang kèm thêm xà lách lô lô và trứng chiên, với tỉ lệ rau thịt hợp lí lại thêm sốt chua ngọt “bí truyền” rưới giữa 2 lát bánh mì mềm thơm tạo nên bữa ăn sáng nhanh, gọn, lẹ nhưng vô cùng dinh dưỡng!",1
//        ));
//        dBhelper.addProduct(new product("SANDWICH GÀ KARAAGE",21000,"https://www.ministop.vn/img/product/detail/60486e23ac30e_2cd344a0d00cb4425992b098b482358c.jpg",
//                "Gà Karaage tươi dinh dưỡng với từng thớ thịt trắng buốt dai ngon được bao bọc bởi lớp bột chiên vàng giòn hấp dẫn sau đó nằm gọn giữa hai mảnh bánh mì tam giác mềm thơm.",1
//        ));
//        dBhelper.addProduct(new product("SANDWICH CÁ CHIÊN & XÚC XÍCH XÔNG KHÓI",25000,"https://www.ministop.vn/img/product/detail/60486e00e23ac_fda982d5c4c5249b3ea433d4c58f88f6.jpg",
//                "MINISTOP vừa mới cho “ra lò” một loại Sandwich cực gây mê: SANDWICH THỊT XÔNG KHÓI & TRỨNG.\n" +
//                        "Cá chiên với lớp vỏ giòn tan bao bọc lấy thịt cá mềm ngọt tự nhiên kết hợp với xúc xích xông khói dai giòn sần sật nằm gọn gẽ giữa 2 lớp bánh mì mềm thơm. Kết hợp thêm chút xà lách tươi ngon để trung hòa trọn vị, ăn hoài không ngán.",1
//        ));
//        dBhelper.addProduct(new product("SANDWICH THỊT NƯỚNG CAY & TRỨNG",26000,"https://www.ministop.vn/img/product/detail/601a253606b65_f264fbd5ddb7ed6b003e106447429942.jpg",
//                "Miếng bánh mì tươi mềm thơm kẹp cặt lấy thịt nướng đậm đà cay xé, kết hợp thêm trứng giàu protein và chất xơ từ xà lách tươi giòn sẽ là lựa chọn tuyệt vời cho bữa sáng tiện lợi.",1
//        ));
//        dBhelper.addProduct(new product("SANDWICH TÔM SỐT THÁI & TRỨNG CHIÊN",27000,"https://www.ministop.vn/img/product/detail/601a2567adb51_d28dd18833eeb173dffccc54a8bce349.jpg",
//                "Vẫn là những miếng bánh mì tươi thơm lừng hương mì và trứng nhưng lại kết hợp lạ lẫm với tôm sốt Thái đậm vị và trứng chiên bùi bùi dinh dưỡng. Chút rau xanh gia nhập để trung hòa trọn vị, ăn không ngán mà lúc chán lại thèm ăn.",1
//        ));
//        dBhelper.addProduct(new product("Sandwich trứng mayo",16000,"https://www.ministop.vn/img/product/detail/5d5f881428f36_49aea79b1bbd29dd70904d3eadf04407.jpg",
//                " Sandwich trứng mayo.",1
//        ));
//        dBhelper.addProduct(new product("TRÀ SỮA THAN TRE",16000,"https://www.ministop.vn/img/product/detail/5f8fb01296bb9_42643fab4f6bf92ebf9bba13d4fb32db.jpg",
//                "Các tín đồ trà sữa đang “truy lùng” một món đồ uống mới toanh, đó là trà sữa than tre. Với hương vị thơm ngon, màu sắc cuốn hút, món trà sữa này đã nhanh chóng thu hút sự quan tâm của nhiều bạn trẻ.",2
//        ));
//        dBhelper.addProduct(new product("TRÀ SỮA TRÀ ĐEN",15000,"https://www.ministop.vn/img/product/detail/5f86d15d613b8_5fab0967b4a1112103590f9cb9599f8b.jpg",
//                "Đậm vị trà, thơm vị sữa, béo ngậy đầy mê hoặc là những gì chúng ta cảm nhận khi chạm môi với trà sữa trà đen của MINISTOP.",2
//        ));
//        dBhelper.addProduct(new product("Nước tinh khiết",5000,"https://anbinhphat.com/wp-content/uploads/2018/04/aquafina-500ml.jpg",
//                "Nước suối tinh khiết được sản xuất theo dây chuyền công nghệ hiện đại Nhật Bản, đảm bảo các yêu cầu về chất lượng, vệ sinh an toàn thực phẩm do Bộ Y tế kiểm định và chứng nhận. Bảo đảm cung cấp cho bạn nguồn nước tinh khiết, an toàn và tươi mát nhất.",2
//        ));
//        dBhelper.addProduct(new product("SET MINI SUSHI XINH XẮN",28000,"https://www.ministop.vn/img/product/detail/5fb76fe62efb3_5beb57ffe0ffb35410a071e4913ed8e0.jpg",
//                " Fan của sushi chắc hẳn sẽ mê tít mắt những cuộn sushi nhỏ nhắn đáng yêu này. Không chỉ chắc nịch, mềm dẻo, dinh dưỡng mà còn vô cùng vừa miệng dễ ăn. Đến MINISTOP thưởng thức ngay các bạn nhé!.",3
//        ));
//        dBhelper.addProduct(new product("Sushi colorful",32000,"https://www.ministop.vn/img/product/detail/5c1c8f0f3118f_01e64ec15a927a4b4b8b8142b612798d.jpg",
//                " Bữa đại tiệc sushi đầy màu sắc với Sushi cá hồi khè & sốt ngọt nigiri, sushi gà sốt mè rang uramaki, sushi thanh cua nigiri, sushi bắp mayo gunkan, sushi xúc xích, sushi màu cam uramaki sẽ đem văn hóa ẩm thực Nhật Bản đến gần bạn hơn",3
//        ));
//        dBhelper.addProduct(new product("Sushi California",26000,"https://www.ministop.vn/img/product/detail/59f9547ba1648_67a2fdf586008b967bbc18d8dd40c3f7.jpg",
//                " Sushi California tại MINISTOP được chế biến thành dạng Sushi cuộn (Uramaki), loại Sushi này được làm từ chả cá hương vị cua, hạt mè trắng, bơ, Mayonnaise (cuộn sao cho theo thứ tự từ bên ngoài: dấm, rong biển khô...)",3
//        ));
//        dBhelper.addProduct(new product("Rau câu sợi 3 vị",14000,"https://www.ministop.vn/img/product/detail/6080edee7b23b_7ba8422d44ec2e0784907cffc7a03151.jpg",
//                " Vị béo cực mê của nước cốt dừa, vị thơm của lá dứa hòa quyện vị đắng nhẹ của cà phê mang đến hương vị thanh mát không kém phần tỉnh táo .",4
//        ));
//        dBhelper.addProduct(new product("BÁNH PANNA COTTA XOÀI",17000,"https://www.ministop.vn/img/product/detail/60138d97b5e67_1fef348b12cf929b2ed7acbaa2f62143.jpg",
//                " Bánh Panna Cotta Xoài với vị chua chua ngọt ngọt từ xoài, vị beo béo từ kem tươi và sữa, mềm mịn tan trong miệng là món dessert tuyệt hảo không thể bỏ qua",4
//        ));
//        dBhelper.addProduct(new product("Bánh su kem Socola",17000,"https://www.ministop.vn/img/product/detail/5f3ce3a193367_24c35fcd856c6aa20da85f735eec3a81.jpg",
//                " Những chiếc bánh su thơm ngào ngạt hương sữa và mì luôn có sức hút khó cưỡng với bất kì ai. Lớp vỏ bánh mềm mỏng bao bọc lấy lớp nhân kem socola beo béo tan chảy trong khoang miệng đầy kích thích.",4
//        ));
//        dBhelper.addProduct(new product("RAU CÂU HOA ĐẬU BIẾC",9000,"https://www.ministop.vn/img/product/detail/5fd9e70b4ab9a_049edcf7c8324659d09ad346f34000d2.jpg",
//                " Ly rau câu xanh biếc ấn tượng thu hút mọi ánh nhìn, hương đậu biếc thoang thoảng bao phủ lấy chiếc rau câu mềm mịn mát lạnh. Vị ngọt vừa phải, cân bằng mọi lượng chất cho cơ thể khỏe mạnh.",4
//        ));
//        dBhelper.addProduct(new product("BÁNH KHOAI LANG MẬT ONG",16000,"https://www.ministop.vn/img/product/detail/5ff53417ad7bd_aac4c648c8041fe7eefce4a0729c02fa.jpg",
//                " Ấn tượng từ ánh nhìn đầu tiên là những gì chiếc bánh khoai lang mật ong mang đến. Trông chúng như những củ khoai thực sự với màu sắc tươi sáng, tuy nhiên lại mang đến cảm giác mềm mại hơn. Từ lần chạm đầu tiên, bạn sẽ mê ngay sự dai dai của chất bánh, sau đó là độ ngọt vừa phải giúp giảm độ ngán, ăn hoài không chán.",4
//        ));
//        dBhelper.addProduct(new product("CHÈ BẮP",9000,"https://www.ministop.vn/img/product/detail/8.jpg",
//                " Hãy cùng thưởng thức vị ngon thuần của bắp, một chút biến tấu kết hợp cùng đậu xanh và nước dừa sẽ mang đến cho bạn thưởng thức 1 món chè bắp - vị ngon tinh tế ngát trời rất tuyệt nhé",4
//        ));
//        dBhelper.addProduct(new product("CHÈ ĐẬU ĐEN",9000,"https://www.ministop.vn/img/product/detail/5cc3d270de49f_aa93966b5fa504677aab1a917062e974.jpg",
//                " Chè đậu đen với gu nam bộ ngon như mẹ nấu lại vừa tốt cho sức khỏe, đặc biệt có thêm thạch jelly giòn ngon thêm phần độc đáo.",4
//        ));
//        dBhelper.addProduct(new product("CHẢ CÁ YUBA",7000,"https://www.ministop.vn/img/product/detail/5fd9dd83456d5_a0786cbd139b4316a95e75cefef2ac37.jpg",
//                " Sự kết hợp từ cá say hòa quyện cùng gia vị tạo nên miếng chả cá dai, mềm ngon không thể sánh với bất cứ loại chả cá nào. Nay tắm đều trong nước lẩu Oden nóng hổi cay nồng càng khiến item này trở nên tuyệt hảo.",5
//        ));
//        dBhelper.addProduct(new product("Thanh Cua Surimi",8000,"https://www.ministop.vn/img/product/detail/5609451692f22_4df151e3d97718e3f89511e11a3ce47d.jpg",
//                " MINISTOP đang sử dụng sản phẩm thanh cua có màu sắc đẹp mắt. Món ăn này sẽ ngon hơn khi vị chua cay của nước súp thấm đều vào vị ngọt của cá.",5
//        ));
//        dBhelper.addProduct(new product("Đậu hủ phô mai",8000,"https://www.ministop.vn/img/product/detail/5d034770189e9_21feec304772980e7d23c2d8993d9547.jpg",
//                " Cảm nhận vị béo ngậy, mềm mại của Đậu hủ phô mai khi nhúng vào ly lẩu Oden cay nồng nóng hổi, tan ngay vào miệng khi cắn miếng đầu tiên, bảo đảm bạn sẽ quên lối về vì độ ngon của món này.",5
//        ));
//        dBhelper.addProduct(new product("Chả quế ớt cá",8000,"https://www.ministop.vn/img/product/detail/5b10e5bd03f0e_c9419a569df975f3370e6c735f6518c2.jpg",
//                " Oden là một trong những món ăn đặc trưng của người Nhật, cũng như là món ăn quen thuộc của các fan của MINISTOP. Nước hầm có vị hơi mặn vừa phải của shoyu, cộng với vị ngọt ra từ các phần ninh, nhất là củ cải. Thành phần chính có trong oden thường là những món được ưa chuộng vào mùa đông, như củ cải, trứng luộc… vì nó làm cho người ăn có cảm giác ấm lên trong tiết trời lạnh giá.",5
//        ));
//        dBhelper.addProduct(new product("Chả cá bạch tuộc",8000,"https://www.ministop.vn/img/product/detail/5c413c11442d5_840e255aee0b96e1c2248a6082765333.jpg",
//                " Ly lẩu Oden thật thiếu sót khi không có Chả cá bạch tuộc ăn kèm. Chả cá được làm từ thịt cá và bạch tuộc tươi xanh của biển, gia vị được tẩm ướp vừa miệng. Khi húp nước lẩu Oden chua cay, cắn miếng chả cá bạch tuộc dai dai thì vị giác của bạn như được đánh thức tức thì",5
//        ));
//        dBhelper.addProduct(new product("Cá viên rau củ thái",7000,"https://www.ministop.vn/img/product/detail/5f3ce42b6ffda_4d235a334dee7bace558fa1ffdb356de.jpg",
//                " Item cá viên rau củ thái thơm nức mùi tươi ngon của hải sản nay được tắm trong nước lẩu Oden nóng hổi cay nồng nức tiếng.",5
//        ));
//        dBhelper.addProduct(new product("Đậu Hũ Hải Sản",7000,"https://www.ministop.vn/img/product/detail/560943bc0dee1_865404d5fcbf454f3287007feb4fdc1d.jpg",
//                " Đậu hũ chiên sơ được chế biến sử dụng nguyên liệu từ hải sản, bán theo dạng xiên que. Miếng đậu hũ mềm, thấm đều vị chua cay của nước súp Oden, mang lại hương vị rất đặc biệt.",5
//        ));
//        dBhelper.addProduct(new product("HOTDOG xúc xích Đức",18000,"https://www.ministop.vn/img/product/detail/5ebbb3ac35b85_9bdf46a327fbd0b32b9749f25ff1f278.jpg",
//                " Bánh mì kẹp xúc xích phiên bản mới mới, dài hơn, dai hơn, đậm chất hơn!",6
//        ));
//        dBhelper.addProduct(new product("Bánh giò",11000,"https://www.ministop.vn/img/product/detail/5ae2f3a5ab1c0_d0322a16ec9844b8f7c56ae4ee662ef7.jpg",
//                " Bánh giò MINISTOP với lớp bột dẻo mềm mịn, nhân thịt hòa quyện cùng nấm tai mèo, hành tây mang lại hương vị thơm ngon, bổ dưỡng.",6
//        ));
//        dBhelper.addProduct(new product("Bánh bao thịt trứng cút",14000,"https://www.ministop.vn/img/product/detail/560943bc0dee1_865404d5fcbf454f3287007feb4fdc1d.jpg",
//                " Bánh bao cao cấp có nhân được làm từ trứng cút, thịt heo xay",6
//        ));
//        dBhelper.addProduct(new product("Burger cá chiên & phô mai thử là nghiền",27000," https://www.ministop.vn/img/product/detail/5d438d25646cc_58a27739a2ec6d2060d215223a5a440f.jpg",
//                " Lớp cá chiên giòn rụm, thơm ngon đầy dinh dưỡng cùng phô mai beo béo đậm đà làm tạo nên vị Burger ngon khó cưỡng.",6
//        ));
//        dBhelper.addProduct(new product("BÒ CUỐN LÁ LỐT",10000,"https://www.ministop.vn/img/product/detail/5f759b8dee1e8_3215ddfee14c71743ccb1d7f8016724d.jpg",
//                " Hương vị thơm ngon đặc trưng, hấp dẫn của thịt bò cuốn lá lốt được tạo nên từ những nguyên liệu tươi chất lượng và bí kíp tẩm ướp 'gia truyền'.",6
//        ));
//        dBhelper.addProduct(new product("GÀ KHÔNG XƯƠNG TẨM BỘT CHIÊN",15000,"https://www.ministop.vn/img/product/detail/5f6ac520e41e5_89a840feaa573d576566bf2af58b43ea.jpg",
//                " Thịt gà dinh dưỡng được tẩm ướp gia vị vừa miệng, bao bọc bởi lớp bột chiên giòn tan sẽ là item ăn vặt cực đỉnh cho các bạn trẻ.",6
//        ));
//        dBhelper.addProduct(new product("Kariman Nhân Pizza",16000,"https://www.ministop.vn/img/product/detail/icon-kariman-pizza-new-260px.jpg",
//                " Mang hình ảnh của Pizza Margherita, Kariman Pizza là sự hòa quyện của sốt cà chua, pho mát, xúc xích, ớt Đà Lạt, nấm… và lớp vỏ giòn tan bọc bên ngoài tạo nên hương vị thơm ngon cho sản phẩm chỉ có tại MINISTOP.",6
//        ));

//       dBhelper.addCustomer(new customer("long","long","123","123456789","2-26-2000","948/43/1, Lê Đức Thọ, F15, Gò Vấp, TP.HCM","long@gmail.com",null));
//        dBhelper.deleteCustomer(2);
    }
    private void EventDangNhap() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=edituser.getText().toString().trim();
                String pass=editpass.getText().toString().trim();
                loginAccount(user,pass);
            }
        });
    }
    private void loginAccount(String user, String pass) {
        if(checkEditText(edituser) &&checkEditText(editpass)){
            if(dBhelper.CheckUserPass(user,pass)==true){
                customer cus= new customer();
                cus=dBhelper.getCustomerbyUser(user);
//                userLocalStore.storeUserData(cus);
//                userLocalStore.setUserLoggedIn(true);
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
//                intent.putExtra("LOGIN",cus);
                IDUSER=cus;
                startActivity(intent);
//                Toast.makeText(this, "Tài khoản tồn tại", Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkEditText(EditText editText){
        if (editText.getText().toString().trim().length()>0)
            return true;
        else {
            editText.setError("Vui lòng nhập thông tin");
        }
        return false;
    }
    private void AnhXa() {
        edituser=(EditText)findViewById(R.id.login_edit_username);
        editpass=(EditText)findViewById(R.id.login_edit_pass);
        btnLogin=(Button)findViewById(R.id.login_btn_login);
        txtdangki=(TextView)findViewById(R.id.login_txt_register);
        txtdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        txtquen=(TextView)findViewById(R.id.login_txt_forgot);
        txtquen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ForgotActivity.class);
                startActivity(intent);
            }
        });
    }

}
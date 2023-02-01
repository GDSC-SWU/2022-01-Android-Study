package org.techtown.myblog

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.kakao.sdk.user.UserApiClient

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //로그아웃
        val kakao_logout_button=findViewById<Button>(R.id.kakao_logout_button)

        kakao_logout_button.setOnClickListener {
            UserApiClient.instance.logout{error->
                //에러가 발생했다
                if(error != null){
                    Toast.makeText(this, "로그아웃실패 $error", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "로그아웃성공", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, FirstActivity::class.java)
                startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }
        //회원탈퇴
        val kakao_unlink_button=findViewById<Button>(R.id.kakao_unlink_button)
        kakao_unlink_button.setOnClickListener {
            UserApiClient.instance.unlink{
                error->
                //에러가 있다
                if(error !=null){
                    Toast.makeText(this, "회원탈퇴 실패 $error", Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(this,"회원탈퇴 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, FirstActivity::class.java)
                    startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                    finish()
                }
            }
        }
    }
}
package dbSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectSample01 {

    public static void main(String[] args) {
                
        //データベース接続と結果取得のための変数
        Connection con =null;
        
        try {
            //1.ドライバーのクラスをjava上で呼び込む
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2.DBと接続する
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/world?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "password（Tak_175566）"
                   );
            //3.DBとやり取りする窓口の(Statementオブジェクト)の作成
            
            // 4, 5. Select文の実行と結果を格納／代入

            // 6. 結果を表示する

        } catch (ClassNotFoundException e) {
            System.err.println("JDBCドライバーのロードに失敗しました。");
            e.printStackTrace();
        }catch (SQLException e) {
            System.err.println("データベースに異常が発生しました。"); 
            e.printStackTrace();
        }finally {
            //7.接続を閉じる
           if ( con !=null) {
               try {
                con.close();
            } catch (SQLException e) {
                System.err.println("データベース切断時にエラーが発生しました。");
                e.printStackTrace();
            }
        } 
        }
    
    }

}

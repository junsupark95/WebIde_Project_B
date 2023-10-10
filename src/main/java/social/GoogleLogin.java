package social;

import java.util.HashMap;
import java.util.Map;

public class GoogleLogin implements SocialLogin{
    private Map<String, Object> googleAttributes;

    // 넘어오는 정보 를 googleAttributes 변수에 저장
    public GoogleLogin(Map<String, Object> googleAttributes) {
        this.googleAttributes = googleAttributes;
    }

    // 제공자 가져오기
    @Override
    public String getProvider() {
        return "Google";
    }

    // 이메일 파싱해서 가져오기
    @Override
    public String getEmail() {
        HashMap<String, Object> account = (HashMap<String, Object>) googleAttributes.get("Google_account");

        String email = (String) account.get("email");
//		System.out.println("memail : "+memail);

        return email;
    }

    // 닉네임 파싱해서 가져오기
    @Override
    public String getNickName() {
        HashMap<String, Object> properties = (HashMap<String, Object>) googleAttributes.get("properties");
        String nickName = (String) properties.get("nickname");

        return nickName;
    }
}

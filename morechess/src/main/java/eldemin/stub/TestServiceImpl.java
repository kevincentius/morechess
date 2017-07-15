package eldemin.stub;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public String test() {
		return "DI Successful!";
	}

}

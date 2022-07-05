package interfaces.impl;

import static org.junit.jupiter.api.Assertions.*;

import dao.AccountRepository;
import dao.UserRepository;
import interfaces.SplitWise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.SplitWiseImpl;

@ExtendWith(MockitoExtension.class)
class SplitExactCommandTest {

  @InjectMocks
  SplitExactCommand splitExactCommand;

  @Test
  public void test(){
    UserRepository userRepository = Mockito.mock(UserRepository.class);
    AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    SplitWise instance = new SplitWiseImpl(userRepository, accountRepository);
    splitExactCommand.execute("EXPENSE u1 1250 2 u2 u3 EXACT 370 880", instance);
  }
}
import dao.AccountRepository;
import dao.UserRepository;
import interfaces.impl.SplitExactCommand;
import interfaces.impl.SplitPercentage;
import service.SplitWiseImpl;
import interfaces.SplitWise;
import interfaces.impl.ShowCommand;
import interfaces.impl.SplitEqualCommand;
import java.util.Arrays;
import java.util.List;
import service.CommandExecutor;
import service.CommandExecutorFactory;

public class SplitwiseRunner {

  public static void main(String[] args) {
    SplitWise splitWise = new SplitWiseImpl(new UserRepository(), new AccountRepository());
    SplitEqualCommand splitEqualCommand = new SplitEqualCommand();
    ShowCommand showCommand = new ShowCommand();
    SplitExactCommand splitExactCommand = new SplitExactCommand();
    SplitPercentage splitPercentage = new SplitPercentage();
    CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(splitEqualCommand,
        showCommand, splitExactCommand, splitPercentage);
    CommandExecutor commandExecutor = new CommandExecutor(splitWise, commandExecutorFactory);
    List<String> commands = Arrays.asList(
        "SHOW",
        "SHOW u1",
        "EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL",
        "SHOW u4",
        "SHOW u1",
        "EXPENSE u1 1250 2 u2 u3 EXACT 370 880",
        "SHOW",
        "EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20",
        "SHOW u1",
        "SHOW");
    commands.forEach(commandExecutor::processCommand);
  }
}

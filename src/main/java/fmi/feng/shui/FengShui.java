package fmi.feng.shui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fmi.feng.shui.command.CommandFactory;
import fmi.feng.shui.command.FengShuiCommand;
import fmi.feng.shui.command.exceptions.InvalidCommandTypeException;
import fmi.feng.shui.command.exceptions.InvalidParameterException;
import fmi.feng.shui.command.exceptions.InvalidParametersCountException;
import fmi.feng.shui.command.exit.ExitCommand;

public class FengShui {

	private final static String COMMAND_PROMPT = "Enter your command here: \n> ";

	private static boolean isActive = true;

	public static void main(String[] args) {
		BufferedReader commandReader = new BufferedReader(new InputStreamReader(System.in));

		while (isActive) {
			try {
				CommandFactory commandFactory = new CommandFactory();
				System.out.print(COMMAND_PROMPT);
				String userInput = commandReader.readLine();
				FengShuiCommand fengShuiCommand = commandFactory.getFengShuiCommand(userInput);
				String result = fengShuiCommand.execute();
				System.out.println(result);

				if (fengShuiCommand instanceof ExitCommand) {
					isActive = false;
					commandReader.close();
				}
			} catch (IOException ioException) {
				System.out.println("An error occured during command reading: " + ioException);
			} catch (InvalidCommandTypeException invalidCommandTypeException) {
				System.out.println(invalidCommandTypeException.getMessage());
			} catch (InvalidParametersCountException invalidParametersCountException) {
				System.out.println(invalidParametersCountException.getMessage());
			} catch (InvalidParameterException invalidParameterException) {
				System.out.println(invalidParameterException.getMessage());
			} finally {
				System.out.println();
			}
		}

	}

}

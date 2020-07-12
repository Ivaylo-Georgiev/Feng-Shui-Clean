package fmi.feng.shui.command;

/**
 * Specifies a single method for execution of supported Feng Shui commands.
 * 
 *
 * @author Ivaylo Georgiev
 */
@FunctionalInterface
public interface FengShuiCommand {

	public String execute();

}

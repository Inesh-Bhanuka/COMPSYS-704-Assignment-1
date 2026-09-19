/** Entry point for RunABS / RunSystemJ: enables the GUI, then runs abs.xml, which
 *  brings up the customer POS and the operator supervision windows with the plant. */
public final class ABSLauncher {
    public static void main(String[] args) {
        System.setProperty("gui.enabled","true");
        com.systemj.SystemJRunner.main(args.length==0?new String[]{"sysj/abs.xml"}:args);
    }
}

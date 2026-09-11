/** Existing RunABS / RunSystemJ launches both customer POS and operator supervision. */
public final class ABSLauncher {
    public static void main(String[] args) {
        System.setProperty("gui.enabled","true");
        com.systemj.SystemJRunner.main(args.length==0?new String[]{"sysj/abs.xml"}:args);
    }
}

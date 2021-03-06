package com.box.samples.aws.sns.utils;

/**
 * {@link java.io.File} related utilities.
 */
public class FileUtils {

    /**
     * Only static members.
     */
    protected FileUtils() {
    }

    /**
     * Builds human readable size.
     *
     * @param size
     *            in bytes
     * @return human readable size
     */
    public static String humanReadableSize(long size) {
        int unit = 1024;
        if (size < unit) {
            return size + " B";
        }
        int exp = (int) (Math.log(size) / Math.log(unit));
        String pre = "KMGTPE".charAt(exp - 1) + "i";
        return String.format("%.1f %sB", size / Math.pow(unit, exp), pre);
    }

}

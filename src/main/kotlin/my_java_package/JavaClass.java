package my_java_package;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaClass {
    public static @NotNull String produceNonNullable() {
        return "ABC";
    }

    public static @Nullable String produceNullable() {
        return null;
    }
}

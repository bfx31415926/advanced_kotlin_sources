package java_interop_1;

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

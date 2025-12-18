package java_interop_1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaClass1 {
    public int id;

    public JavaClass1(int id) {
        this.id = id;
    }

    public static @NotNull String produceNonNullable() {
        return "ABC";
    }

    public static @Nullable String produceNullable() {
        return null;
    }
}

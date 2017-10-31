package tech.sourced.siva;

import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

/**
 * Header contains the meta information from a file that a single {@link IndexEntry}
 * keeps in the siva file.
 */
public class Header {
    private final String name;
    private final FileTime modificationTime;
    private final Set<PosixFilePermission> fileMode;
    private final Flag flag;

    /**
     * Builds a Header object with the given file meta information(name, UNIX modification
     * time, UNIX file mode and Flag).
     *
     * @param name             Entry name.
     * @param modificationTime Modification time as UNIX time in nanoseconds.
     * @param fileMode         UNIX mode.
     * @param flag             supported flags @see {@link Flag}
     */
    Header(final String name, final FileTime modificationTime,
           final Set<PosixFilePermission> fileMode, final Flag flag) {
        this.name = name;
        this.modificationTime = modificationTime;
        this.fileMode = fileMode;
        this.flag = flag;
    }

    /**
     * @return Entry name.
     */
    public final String getName() {
        return name;
    }

    /**
     * @return Modification time as Unix time in nanoseconds.
     */
    public final FileTime getModificationTime() {
        return modificationTime;
    }

    /**
     * @return UNIX file mode.
     */
    public final Set<PosixFilePermission> getFileMode() {
        return fileMode;
    }

    /**
     * @return {@link Flag}
     */
    public final Flag getFlag() {
        return flag;
    }
}

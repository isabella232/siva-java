package tech.sourced.siva;

import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

/**
 * IndexEntry represents each entry contained in an {@link Index}.
 * An IndexEntry must contain the following:
 * - A {@link Header}
 * - Offset of the file content, relative to the beginning of the block.
 * - Size of the file content.
 * - CRC32.
 * - A {@link Flag}.
 *
 * @see <a href="https://github.com/src-d/go-siva/blob/master/SPEC.md">
 * Siva Format Specification</a>
 */
public class IndexEntry extends Header {
    private static final long CRC_32_MASK = 0xffffffffL;

    private final long intStart;
    private final long size;
    private final int crc32;
    private final long absStart;

    /**
     * Builds an IndexEntry composed by the {@link Header} properties and the given specific
     * properties related to the siva file.
     *
     * @param name             Entry name.
     * @param modificationTime Modification time as UNIX time in nanoseconds.
     * @param fileMode         UNIX mode.
     * @param flag             supported flags @see {@link Flag}
     * @param intStart         Offset of the file content, relative to the beginning of the block.
     * @param size             size of the file content.
     * @param crc32            CRC32.
     * @param absStart         Offset from the beginning of the block.
     */
    public IndexEntry(final String name, final FileTime modificationTime,
                      final Set<PosixFilePermission> fileMode, final Flag flag,
                      final long intStart, final long size, final int crc32,
                      final long absStart) {
        super(name, modificationTime, fileMode, flag);
        this.intStart = intStart;
        this.size = size;
        this.crc32 = crc32;
        this.absStart = absStart;
    }

    /**
     * @return Offset from the beginning of the block.
     */
    public final long getAbsStart() {
        return absStart;
    }

    /**
     * @return Offset of the file content, relative to the beginning of the block.
     */
    public final long getIntStart() {
        return intStart;
    }

    /**
     * @return size of the file content.
     */
    public final long getSize() {
        return size;
    }

    /**
     * @return CRC32.
     */
    public final long getCrc32() {
        return (long) this.crc32 & CRC_32_MASK;
    }

}


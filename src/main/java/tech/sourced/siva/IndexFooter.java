package tech.sourced.siva;

/**
 * IndexFooter keeps meta information about the {@link Index}. It consists of:
 * - Number of entries in the block.
 * - Index size in bytes.
 * - Block size in bytes.
 * - CRC32.
 *
 * @see <a href="https://github.com/src-d/go-siva/blob/master/SPEC.md">
 * Siva Format Specification</a>
 */
class IndexFooter {
    private final long entryCount;
    private final long indexSize;
    private final long blockSize;
    private final long crc32;

    /**
     * Constructor.
     *
     * @param entryCount Number of entries in the block.
     * @param indexSize  Index size in bytes.
     * @param blockSize  Block size in bytes.
     * @param crc32      CRC32.
     */
    IndexFooter(
            final long entryCount,
            final long indexSize,
            final long blockSize,
            final long crc32
    ) {
        this.entryCount = entryCount;
        this.indexSize = indexSize;
        this.blockSize = blockSize;
        this.crc32 = crc32;
    }

    /**
     * @return Number of entries in the block.
     */
    long getEntryCount() {
        return entryCount;
    }

    /**
     * @return Index size in bytes.
     */
    long getIndexSize() {
        return indexSize;
    }

    /**
     * @return Block size in bytes.
     */
    long getBlockSize() {
        return blockSize;
    }

    /**
     * @return CRC32.
     */
    long getCrc32() {
        return crc32;
    }
}

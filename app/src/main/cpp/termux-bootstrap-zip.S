.global blob
.global blob_size

.section .rodata
blob:
    # Conditional assembly based on architecture
#if defined(__i686__)
    .incbin "bootstrap-i686.zip"
#elif defined(__x86_64__)
    .incbin "bootstrap-x86_64.zip"
#elif defined(__aarch64__)
    .incbin "bootstrap-aarch64.zip"
#elif defined(__arm__)
    .incbin "bootstrap-arm.zip"
#else
    # Unsupported architecture error
    .error "Unsupported architecture"
#endif

1:
blob_size:
    # Calculate size of blob
    .int 1b - blob

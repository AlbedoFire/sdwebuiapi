package org.sdwebuiapi

enum class HiResUpscaler(val type:String) {
    None("None"),
    Latent("Latent"),
    LatentAntialiased("Latent (antialiased)"),
    LatentBicubic("Latent (bicubic)"),
    LatentBicubicAntialiased("Latent (bicubic antialiased)"),
    LatentNearest("Latent (nearest)"),
    LatentNearestExact("Latent (nearest-exact)"),
    Lanczos("Lanczos"),
    Nearest("Nearest"),
    ESRGAN_4x("R-ESRGAN 4x+"),
    LDSR("LDSR"),
    ScuNET_GAN("ScuNET GAN"),
    ScuNET_PSNR("ScuNET PSNR"),
    SwinIR_4x("SwinIR 4x");
}
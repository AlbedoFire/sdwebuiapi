package org.sdwebuiapi

enum class Upscaler(val tyep:String) {

    None("None"),
    Lanczos("Lanczos"),
    Nearest("Nearest"),
    LDSR("LDSR"),
    BSRGAN("BSRGAN"),
    ESRGAN_4x("R-ESRGAN 4x+"),
    R_ESRGAN_General_4xV3("R-ESRGAN General 4xV3"),
    ScuNET_GAN("ScuNET GAN"),
    ScuNET_PSNR("ScuNET PSNR"),
    SwinIR_4x("SwinIR 4x");
}
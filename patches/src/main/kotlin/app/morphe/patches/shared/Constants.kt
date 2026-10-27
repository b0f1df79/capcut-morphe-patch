package app.morphe.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

/** CapCut target metadata shared by the remaining patches and verification task. */
object Constants {
    const val CAPCUT_PACKAGE_NAME = "com.lemon.lvoverseas"
    const val CAPCUT_TARGET_VERSION = "19.9.0"
    const val CAPCUT_INPUT_SHA256 = "3c74a9941237451953fe4ed1abe477b7413d11d11a4b5b45a17441afd30f2c38"

    val COMPATIBILITY_CAPCUT = Compatibility(
        name = "CapCut",
        packageName = CAPCUT_PACKAGE_NAME,
        apkFileType = ApkFileType.APK,
        appIconColor = 0x000000,
        targets = listOf(
            AppTarget(
                version = CAPCUT_TARGET_VERSION,
                description = "Download com.lemon.lvoverseas v$CAPCUT_TARGET_VERSION (APK) arm64-v8a nodpi versionCode 19900002 from APKMirror",
            )
        )
    )
}

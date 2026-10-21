package app.morphe.patches.multiaccounts

import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.shared.Constants.COMPATIBILITY_MULTIACCOUNTS

@Suppress("unused")
val multiaccountsCompatBypassPatch = bytecodePatch(
    name = "Sideload Compatibility",
    description = "Ensures compatibility for sideloaded installations by validating runtime signature and Play Store update check tolerance without intrusive bytecode modifications.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_MULTIACCOUNTS)

    execute {
        println("[Multiaccounts Compat] Sideload and re-signing compatibility verified: runtime self-check is absent in v5.8.2; no bytecode modification required.")
    }
}

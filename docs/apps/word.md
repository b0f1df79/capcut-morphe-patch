# Word Patches Guide

Technical documentation and patch catalog for Microsoft Word on Android.

---

## 1. Target & Compatibility

| Property | Value |
| :--- | :--- |
| **Target App** | Word |
| **Package Name** | `com.microsoft.office.word` |
| **Target Version** | `16.0.20527.20034` |
| **Target Package Format** | APKM |
| **Primary Architecture** | `arm64-v8a` |
| **Authoritative Source** | APKMirror |
| **Download Target** | [Word 16.0.20527.20034 (arm64-v8a, 120-480dpi, versionCode 2005437911, APKM)](https://www.apkmirror.com/apk/microsoft-corporation/microsoft-word/microsoft-word-16-0-20527-20034-release/) |

---

## 2. Applied Patches Catalog

| Patch Name | Typology | Default State | Dependencies | Description |
| :--- | :--- | :--- | :--- | :--- |
| **Unlock 365 Family** | `bytecodePatch` | `true` (Enabled) | None | Unlocks Microsoft 365 Family subscription features locally. |

---

## 3. Deep Technical Breakdown

### A. Bytecode Feature Unlocking Layer (`bytecodePatch`)

1. **Unlock 365 Family**:
   - **Objective**: Unlock premium subscription features and editing capabilities locally.
   - **How**: Forces subscription status checks to return true and bypasses enterprise license validation.

---

## 4. Known Limitations

None evidenced by patch sources.

---

## 5. Follow-up Modules (Out of Scope for This Release)

The following modules are present in the PowerPoint target but have not been ported to Word yet:

- **Disable Login Requirement**: Removes login requirement and FTUX paywall screens.
- **Block Telemetry & Trackers**: Neutralizes Microsoft OneDS/Aria lifecycle and ad measurement identifiers.
- **Bypass Code Transparency**: Short-circuits verification checks to report immediate success.

---

## 6. Canonical Universal Patches

The generic maintenance patches (screen densities, languages) are covered by the universal patches in the canonical collection [kveld-morphe-patches](https://github.com/kveld9/kveld-morphe-patches): `Remove Unused Screen Sizes` and `Remove Extra Languages`. For further generic maintenance (packaging leftovers, background sync, native trackers, telemetry) that collection also provides `Clean App Packaging`, `Stop Background Sync`, `Remove Tracking Libraries` and `Block Trackers`. Add that source in Morphe Manager alongside this one to use them; universal patches apply to any APK, including Word.

<a name="top"></a>
<p align="center">
  <a href="https://github.com/b0f1df79/capcut-morphe-patche/releases/latest"><img src="https://img.shields.io/github/v/release/b0f1df79/capcut-morphe-patche?color=8A2BE2&label=Release&logo=github&style=flat-square" alt="Latest Release" /></a>
  <a href="https://github.com/b0f1df79/capcut-morphe-patche/stargazers"><img src="https://img.shields.io/github/stars/b0f1df79/capcut-morphe-patche?color=8A2BE2&style=flat-square&logo=github" alt="GitHub stars" /></a>
  <a href="https://github.com/b0f1df79/capcut-morphe-patche/releases"><img src="https://img.shields.io/github/downloads/b0f1df79/capcut-morphe-patche/total?color=8A2BE2&style=flat-square&logo=github" alt="Total Downloads" /></a>
  <img src="https://img.shields.io/badge/Build_Engine-Morphe_Patcher-8A2BE2?style=flat-square" alt="Build engine: Morphe patcher" />
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-GPLv3-8A2BE2?style=flat-square" alt="License: GNU GPLv3" /></a>
</p>

<h1 align="center">Đắc patches</h1>

<p align="center">
  Standalone, app-specific patches for companion targets for use with the <b><a href="https://morphe.software">Morphe</a></b> patcher framework.<br>
  Companion to the main collection: <a href="https://github.com/kveld9/kveld-morphe-patches">kveld-morphe-patches</a>.
</p>

<p align="center">
  <a href="https://morphe.software/add-source?github=b0f1df79/capcut-morphe-patche"><img src="https://img.shields.io/badge/Morphe_Manager-Add_Patch_Source-8A2BE2?style=for-the-badge&logo=android&logoColor=white" alt="Add Source to Morphe Manager" /></a>
  &nbsp;&nbsp;
  <a href="https://github.com/b0f1df79/capcut-morphe-patche/releases/latest"><img src="https://img.shields.io/badge/Direct_Download-Get_.MPP_Bundle-0070F3?style=for-the-badge&logo=github&logoColor=white" alt="Download Latest Release" /></a>
  &nbsp;&nbsp;
  <a href="https://t.me/kveldmorphe"><img src="https://img.shields.io/badge/Telegram-Official_Support-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" alt="Official Telegram Support Group" /></a>
</p>

---

## Table of Contents

![](images/divider-purple.svg)

- [Quick Start](#quick-start)
- [Key Advantages](#key-advantages)
- [Supported Targets & Downloads](#supported-targets--downloads)
- [Universal Patches (Companion Source)](#universal-patches-companion-source)
- [Patch Catalog](#patch-catalog)
- [Documentation & Guides](#documentation--guides)
- [Contributing & Feature Requests](#contributing--feature-requests)
- [Community & Support](#community--support)
- [Credits & Contributors](#credits--contributors)
- [Legal Disclaimer](#legal-disclaimer)
- [License](#license)

<a name="quick-start"></a>
## Quick Start

![](images/divider-purple.svg)

1. **Install Morphe Manager**: Download and install the latest release of [Morphe Manager](https://github.com/morphe-app/morphe-manager) on your Android device.
2. **Download Target APK**: Download the supported APK or APKM bundle for your target application, matching the exact version listed in its [Application Guide](#application-guides) (section 1, Target & Compatibility).
3. **Add Patch Source**: Add this repository as a custom patch source in Morphe Manager:
   - Use the one-click [Add Patch Source](https://morphe.software/add-source?github=b0f1df79/capcut-morphe-patche) action, or manually enter `b0f1df79/capcut-morphe-patche` in Morphe Manager under **Settings > Sources**.
4. **Patch & Install**: Open Morphe Manager, select the downloaded target APK/APKM, select your desired patches, tap **Patch**, and install the resulting build.

> [!NOTE]
> Root access is not required. Morphe modifies application packages directly in userland. Always use the exact target version specified in the app's guide to satisfy compile-time fingerprint assertions.

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="key-advantages"></a>
## Key Advantages

![](images/divider-purple.svg)

- **Zero Runtime Overhead**: compile-time Dalvik bytecode manipulation and XML transformation without background daemons, proxy servers, or Xposed frameworks.
- **Client-Side Telemetry Neutralization**: disables tracking, analytics, and crash reporting at method call sites and manifest components instead of fragile network-level blackholing.
- **Rootless & Standalone**: operates directly on userland APKs and APKM split bundles; no Magisk, KernelSU, or root privileges required.
- **Strict Upstream Parity**: each app targets exactly one version, the latest supported release, with exact fingerprint assertions.

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="supported-targets--downloads"></a>
## Supported Targets & Downloads

![](images/divider-purple.svg)

Each app targets exactly one version, the latest supported release. See the [Patch Catalog](#patch-catalog) for the per-app supported version, and each [Application Guide](#application-guides) (section 1, Target & Compatibility) for package name, exact version, variant, and download source. Always use the exact version listed there.

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="universal-patches-companion-source"></a>
## Universal Patches (Companion Source)

![](images/divider-purple.svg)

This source ships app-specific patches only. Generic maintenance that works on any app (unused languages, screen sizes, packaging leftovers, background activity, common trackers) lives in the companion collection [kveld-morphe-patches](https://github.com/kveld9/kveld-morphe-patches) as universal patches, and applies to every app in this repo as well.

To use them, add `kveld9/kveld-morphe-patches` as a second source in Morphe Manager (or via [one-click](https://morphe.software/add-source?github=kveld9/kveld-morphe-patches)) alongside this collection.

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="patch-catalog"></a>
## Patch Catalog

![](images/divider-purple.svg)


<!-- PATCHES_START -->
<details>
<summary>CapCut&nbsp;&nbsp;•&nbsp;&nbsp;<b>13 patches</b></summary>
<br>

**Supported versions:**

| 19.9.0 |
| :---: |
| Download com.lemon.lvoverseas v19.9.0 (APK) arm64-v8a nodpi versionCode 19900002 from APKMirror |

| Patch | Description | Options |
|----------|----------------|-----------|
| **Block Telemetry & Trackers** | Neutralizes Google AppMeasurement, AppsFlyer, ByteDance AppLog, APM/Slardar, Gecko, Pitaya, BDTuring, and UserGrowth event dispatchers. |  |
| **Bypass Effects Region Restriction** | Fixes effects, transitions, and templates failing to load (ByteDance Shark WAF block) by spoofing device_platform to 'windows' and resetting deviceId in effect requests. |  |
| **Bypass GeoBlock Region Restriction** | Forces CapCut GeoBlock config lists (cert, dock, entrance, page, scheme) to empty so region-blocked surfaces stay enabled. Server-refused content may still fail to load. |  |
| **Bypass Signature Check** | Spoofs the official APK signature (SHA-256) for tamper telemetry, drops the server-driven signature blacklist, silences the abnormal-source toast, and disables the Godzilla inject-detect gate so re-signed builds are not blocked. |  |
| **Bypass Unsafe Package Modal** | Replaces the unsafe-package modal fallback URL in the Lynx schema defaults with the real template portal URL so region-blocked or untrusted-client fallbacks open templates instead of the blocking security notice. |  |
| **Locale Assets Slimmer** | Strips unselected CapCut asset locale bundles (assets/locales/*.json) from the APK. English is always preserved. For res/values-* string tables use the canonical universal Remove Extra Languages patch. | • Locales to keep |
| **Native Bloat Slimmer** | Strips non-essential companion native libraries by zeroing bytes in-situ. Always zeroes AppLovin ad crash reporter. WARNING: Stripping speech recognition and synthesis engines (libspeech*.so) disables voice recognition, voiceover captions, and speech-to-text features. | • Trim Speech Engines (Breaks Voice Features) |
| **Neutralize Play Billing** | Stubs Google Play Billing client calls and disables billing manifest components for graceful degradation on devices without GMS. |  |
| **Redirect API to v2 Boot** | Loads effects, feeds and templates where default endpoints are blocked by using official alternate endpoints. |  |
| **Remove Watermark** | Forces CapCut watermark-removal gates and default ending gate to allow export without watermark or outro. |  |
| **Unlock Premium** | Forces CapCut VIP gates to return true (SubscribeImpl, PayVipImpl, UserVipInfo, UserDetailInfo, VipUserServiceImpl, SubscribeCloudImpl) plus central account status flags (BusinessManager). Cloud-gated assets may still fail. |  |
| **Unlock Premium Templates** | Marks premium template styles as available so locked template features stay usable. |  |
| **Unlock Ultra HD Export** | Forces CapCut Ultra HD / high-resolution export gates to unlocked so 4K export options stay available. |  |

</details>

<!-- PATCHES_END -->

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="documentation--guides"></a>
## Documentation & Guides

![](images/divider-purple.svg)

### General Documentation

| Document | Description |
| :--- | :--- |
| [Building & Development](docs/building.md) | Toolchain prerequisites, Gradle build tasks, in-situ patching gate, and catalog synchronization. |
| [Project Scope](docs/out-of-scope.md) | Compile-time invariants, single-version policy, and rejected feature categories. |
| [Security Policy](SECURITY.md) | Vulnerability disclosure procedures and supported security models. |
| [Changelog](CHANGELOG.md) | Complete history of changes, patch updates, and releases. |

### Application Guides

| App | Guide |
| :--- | :--- |
| CapCut | [Guide](docs/apps/capcut.md) |

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="contributing--feature-requests"></a>
## Contributing & Feature Requests

![](images/divider-purple.svg)

Before proposing new features, review the [Project Scope](docs/out-of-scope.md). Every patch change must pass the in-situ verification gate with 0 failed patches, 0 fingerprint mismatches, and 0 smali compile errors:

```bash
./gradlew runPatchTest -Papp=capcut
./gradlew check
```

For bug reports, patch inquiries, or feature proposals, open an issue using the templates:
- [Submit an Issue or Feature Request](https://github.com/b0f1df79/capcut-morphe-patche/issues/new/choose)

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="community--support"></a>
## Community & Support

![](images/divider-purple.svg)

| Channel / Resource | Link | Description |
| :--- | :--- | :--- |
| **Telegram Support** | [t.me/kveldmorphe](https://t.me/kveldmorphe) | Official community discussion, updates, and support group. |
| **Issue Tracker** | [GitHub Issues](https://github.com/b0f1df79/capcut-morphe-patche/issues/new/choose) | Bug reports and feature proposals using structured templates. |
| **Security Policy** | [SECURITY.md](SECURITY.md) | Reporting security vulnerabilities and disclosure guidelines. |
| **Release Notes** | [Changelog](CHANGELOG.md) / [Releases](https://github.com/b0f1df79/capcut-morphe-patche/releases) | Detailed history of releases and patch changes. |

> [!NOTE]
> This repository is a companion collection for standalone applications. For Brave, Gboard Lite, TikTok, and other primary targets, visit the main patch repository: **[kveld-morphe-patches](https://github.com/kveld9/kveld-morphe-patches)**.

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="credits--contributors"></a>
## Credits & Contributors

![](images/divider-purple.svg)

<!-- CONTRIBUTORS_START -->
| Contributor | Role & Contributions |
| :--- | :--- |
| <a href="https://github.com/aeries0x"><img src="https://github.com/aeries0x.png" alt="@aeries0x" width="48" height="48" style="border-radius: 50%;" /><br><b>@aeries0x</b></a> | Feature request: Proposed X – Default reply sorting (open replies sorted by Likes) feature request ([#12](https://github.com/b0f1df79/capcut-morphe-patch/issues/12)). |
| <a href="https://github.com/springfurst"><img src="https://github.com/springfurst.png" alt="@springfurst" width="48" height="48" style="border-radius: 50%;" /><br><b>@springfurst</b></a> | Contributed the Use Places API (New) Moovit search patch ([#44](https://github.com/kveld9/kveld-extra-morphe-patches/pull/44)). |
<!-- CONTRIBUTORS_END -->

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="legal-disclaimer"></a>
## Legal Disclaimer

![](images/divider-purple.svg)

**Đắc patches** is an independent, community-driven open-source project and is not affiliated, associated, authorized, endorsed by, or in any way officially connected with any of the respective app publishers or their subsidiaries or affiliates.

All product names, logos, brands, and registered trademarks mentioned in this repository are the property of their respective holders. Their inclusion does not imply affiliation with or endorsement by them.

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

<a name="license"></a>
## License

![](images/divider-purple.svg)

This project is licensed under the GNU General Public License v3.0. See [LICENSE](LICENSE) and [NOTICE](NOTICE) for the full license text and copyright notices.

<p align="center"><a href="#top"><b>&uarr; Back to top</b></a></p>

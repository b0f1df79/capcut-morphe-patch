# Multiple Accounts Patches Guide

Technical documentation and patch catalog for Multiple Accounts (com.excelliance.multiaccounts) on Android.

---

## 1. Target & Compatibility

| Property | Value |
| :--- | :--- |
| **Target App** | Multiple Accounts |
| **Package Name** | `com.excelliance.multiaccounts` |
| **Target Version** | `5.8.2` |
| **Target Package Format** | APK (standalone) |
| **Primary Architecture** | `arm64-v8a` |
| **Download Target** | [APKMirror](https://www.apkmirror.com/apk/excelliance-technology/multiple-accounts-dual-accounts/) (`com.excelliance.multiaccounts` v5.8.2 arm64-v8a versionCode 672) |
| **Authoritative Source** | APKMirror |

---

## 2. Applied Patches Catalog

| Patch Name | Typology | Default State | Dependencies | Description |
| :--- | :--- | :--- | :--- | :--- |
| **Multiaccounts Telemetry Manifest Purge** | `resourcePatch` | `false` (Opt-in) | None | Strips advertising permissions, disables ad network providers, activities, services, and receivers, prunes telemetry registrars, and injects opt-out metadata flags in AndroidManifest.xml. |
| **Block Telemetry & Trackers** | `bytecodePatch` | `true` (Enabled) | `Multiaccounts Telemetry Manifest Purge` | Neutralizes in-house statistics, ByteDance AppLog, AppLovin MAX, Google Measurement, AppMetrica, Tenjin, IronSource, and Pangle ad/telemetry dispatchers, redirects isolated tracking host literals to 0.0.0.0, disables ad and tracking manifest components, and injects opt-out metadata flags. |

---

## 3. Deep Technical Breakdown

### Target Architecture & Cloned Space Overview

Multiple Accounts (2Accounts dual-space clone) is a virtualization container application enabling dual and multi-instance execution of installed Android applications within isolated sandboxed processes.

### A. Manifest Purge Layer (`resourcePatch`)

1. **Multiaccounts Telemetry Manifest Purge**:
   - **Objective**: Prevent ad network auto-initialization, advertising ID collection, ad rendering activities, background measurement services, and telemetry scheduling in `AndroidManifest.xml`.
   - **How**:
     - **Permissions**: Strips `com.google.android.gms.permission.AD_ID`, `com.google.android.gms.permission.AD_ID_NOTIFICATION`, `com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE`, `BIND_GET_INSTALL_REFERRER_SERVICE`, and `android.permission.ACCESS_ADSERVICES_*` (`ATTRIBUTION`, `AD_ID`, `TOPICS`).
     - **Providers (12 disabled)**: Disables `com.applovin.sdk.AppLovinInitProvider`, `com.yandex.mobile.ads.core.initializer.MobileAdsInitializeProvider`, `com.yandex.mobile.ads.features.debugpanel.data.local.DebugPanelFileProvider`, `io.appmetrica.analytics.internal.PreloadInfoContentProvider`, `com.google.android.gms.ads.MobileAdsInitProvider`, `com.vungle.ads.VungleProvider`, `com.ironsource.lifecycle.IronsourceLifecycleProvider`, `com.ironsource.lifecycle.LevelPlayActivityLifecycleProvider`, `com.android.staticslio.StaticDataContentProvider`, `com.mbridge.msdk.config.component.status.MBComponentLifecycleProvider`, `com.secmtp.sdk.core.api.ATInitializationProvider`, and `com.smartdigimkt.sdk.api.SDMInitializationProvider`.
     - **Services (8 disabled)**: Disables AppLovin `FullscreenAdService` and `AppRestartDuringAdDetectionService`, Google `AppMeasurementService`, `AppMeasurementJobService`, and `AdService`, Yandex `AppMetricaService`, and Google DataTransport `TransportBackendDiscovery` and `JobInfoSchedulerService`.
     - **Receivers (4 disabled)**: Disables Google `AppMeasurementReceiver`, DataTransport `AlarmManagerSchedulerBroadcastReceiver`, ByteDance AppLog `Collector`, and Mintegral `NetWorkChangeReceiver`.
     - **Activities (81 disabled)**: Disables all interstitial, rewarded, banner, debugger, and mediation activities across AppLovin MAX (20 activities including `MaxDebugger*`, `MaxCreativeDebugger*`), Yandex (`AdActivity`, `IntegrationInspectorActivity`), Unity Ads / IronSource (10 activities), Verve / HyprMX (7 activities), Google Ads (3 activities), ByteDance / Pangle (18 activities), Vungle (`VungleActivity`), Mintegral (4 activities), TopOn / Secmtp / SmartDigiMkt (14 activities), and app-internal splash ad activities (`TopOnAdSplashActivity`, `ApiAdSplashActivity`).
     - **Component Discovery**: Prunes `AnalyticsConnectorRegistrar` from `com.google.firebase.components.ComponentDiscoveryService` while preserving Firebase Messaging, RemoteConfig, Abt, and Installations registrars.
     - **Opt-Out Metadata**: Injects declarative opt-out flags for Firebase Analytics, Crashlytics, Performance, Google Analytics ADID / personalization, Yandex Mobile Ads automatic initialization (`false`), MyTarget autoInitMode (`0`), and Google Ads initialization optimization (`false`).
     - **Preservation**: Core guest container virtualization components (`com.excelliance.kxqp.platform.proxy.*`), app-owned push (`MyFirebaseMessagingService`), Firebase push infra (`FirebaseMessagingService`, `FirebaseInstanceIdReceiver`, `FirebaseInitProvider`), Google Play Billing (`ProxyBillingActivity`, `ProxyBillingActivityV2`), and Zendesk support components (`DeepLinkingBroadcastReceiver`, `SupportSdkStartupProvider`, etc.) are strictly preserved.

### B. Bytecode Dispatcher Neutralization Layer (`bytecodePatch`)

1. **Block Telemetry & Trackers**:
   - **Objective**: Neutralize active runtime telemetry, analytics, and ad measurement pipelines directly at Dalvik bytecode entrypoints and sinkhole isolated host literals without breaking asynchronous promises or application lifecycles.
   - **How**:
     - **In-House Statistics (`com.android.staticslio.StatisticsManager`)**: 16 void dispatchers stubbed with early `return-void` (`uploadData`, `uploadBeanImmediateInternal`, `startImmediateUploadData`, `startNextUploadDataTask`, `uploadAllData`, `uploadBean`, `uploadBeanImmediate`, `uploadStaticData`, `upLoadBasicInfoStaticData`).
     - **ByteDance AppLog (`com.bytedance.applog.AppLog`)**: 21 void event/session tracking methods stubbed with `return-void` (`onEventV3`, `onMiscEvent`, `trackClick`, `trackPage`, `startDurationEvent`, `stopDurationEvent`, `pauseDurationEvent`, `resumeDurationEvent`, `profileSet`, `profileSetOnce`, `profileIncrement`, `profileAppend`, `flush`).
     - **AppLovin MAX (`com.applovin.impl.sdk.EventServiceImpl`, `com.applovin.sdk.AppLovinSdk`)**: 7 event dispatchers stubbed with `return-void` (`trackEvent`, `trackEventSynchronously`, `trackCheckout`, `trackInAppPurchase`, `maybeTrackAppOpenEvent`), and 3 mediation debugger entrypoints stubbed (`showCreativeDebugger`, `showMediationDebugger`).
     - **Google Measurement (`com.google.android.gms.measurement.AppMeasurement`)**: 2 void event dispatchers stubbed (`logEventInternal`, `logEventInternalNoInterceptor`).
     - **Yandex AppMetrica (`io.appmetrica.analytics.AppMetrica`)**: 16 void event, revenue, attribution, and error reporters stubbed with `return-void` (`reportEvent`, `reportError`, `reportUnhandledException`, `reportAppOpen`, `reportRevenue`, `reportAdRevenue`, `reportExternalAdRevenue`, `reportExternalAttribution`, `reportUserProfile`, `sendEventsBuffer`).
     - **Tenjin Attribution SDK (`com.tenjin.android.TenjinSDK`)**: 32 void connection, event, ad impression, and transaction tracking dispatchers stubbed with `return-void` (`connect`, `eventWithName`, `eventWithNameAndValue`, `eventAdImpression*`, `transaction*`). Direction-sensitive consent/opt-out setters (`optOut`, `optIn`) are strictly excluded per Section 1.E.
     - **Yandex Mobile Ads (`com.yandex.mobile.ads.common.MobileAds`)**: Logging and debug panel display stubbed (`enableLogging`, `showDebugPanel`).
     - **IronSource Mediation (`com.ironsource.mediationsdk.IronSource`)**: Ad revenue reporter stubbed (`setAdRevenueData`).
     - **Pangle PAGSdk (`com.bytedance.sdk.openadsdk.api.init.PAGSdk`)**: Ad revenue reporter stubbed (`setAdRevenue`).
     - **DNS-over-HTTPS & In-House Endpoint Host Redirection**: Indexed string fingerprints redirect isolated host literals (`log.multispaces.net`, `ad.multispaces.net`) and telemetry URL hosts (`statis.multispaces.net`) to `0.0.0.0` while strictly preserving scheme, path, and URL structure for URI parser stability.

---

## 4. Behavioral Hazards Warning

1. **Dual-Space and Process Isolation**:
   Multiple Accounts operates as a dual-space and process-level clone container where secondary accounts run in isolated guest processes. Patching bytecode or manifest components must preserve guest container virtualization lifecycles:
   - Must not break cloned-app launch flows or process forks.
   - Must not disrupt push notification dispatch mechanisms within cloned app containers.
   - Must keep in-app billing paths functional where required.

2. **Push Notification Infrastructure and FirebaseInitProvider Preservation**:
   `com.google.firebase.provider.FirebaseInitProvider`, `com.google.firebase.messaging.FirebaseMessagingService`, and `com.google.firebase.iid.FirebaseInstanceIdReceiver` must remain enabled. Multiple Accounts relies on Firebase initialization for dual-space notification multiplexing and synchronous app-state services. Telemetry suppression is achieved through manifest component disabling of analytics services, removal of `AnalyticsConnectorRegistrar`, declarative opt-out flags, and Dalvik bytecode stubs without altering core Firebase runtime initialization.

---

## 5. Canonical Universal Patches

Generic resource slimming and device optimization patches are provided by universal patches in the canonical collection [kveld-morphe-patches](https://github.com/kveld9/kveld-morphe-patches): `Remove Unused Screen Sizes` and `Remove Extra Languages`. Add that source in Morphe Manager alongside this one to use them.

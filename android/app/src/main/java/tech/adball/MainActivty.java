package tech.adball;
1	import android.content.res.Configuration;
3	import expo.modules.ApplicationLifecycleDispatcher;
4	import expo.modules.ReactNativeHostWrapper;
2	5	 
3	6	import android.app.Application;
4	7	import android.content.Context;
16	19	public class MainApplication extends Application implements ReactApplication {
17	20	 
18	21	  private final ReactNativeHost mReactNativeHost =
19		      new ReactNativeHost(this) {
22	      new ReactNativeHostWrapper(this, new ReactNativeHost(this) {
20	23	        @Override
21	24	        public boolean getUseDeveloperSupport() {
22	25	          return BuildConfig.DEBUG;
35	38	        protected String getJSMainModuleName() {
36	39	          return "index";
37	40	        }
38		      };
41	      });
39	42	 
40	43	  private final ReactNativeHost mNewArchitectureNativeHost =
41		      new MainApplicationReactNativeHost(this);
44	      new ReactNativeHostWrapper(this, new MainApplicationReactNativeHost(this));
42	45	 
43	46	  @Override
44	47	  public ReactNativeHost getReactNativeHost() {
56	59	    ReactFeatureFlags.useTurboModules = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
57	60	    SoLoader.init(this, /* native exopackage */ false);
58	61	    initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
62	    ApplicationLifecycleDispatcher.onApplicationCreate(this);
59	63	  }
60	64	 
61	65	  /**
88	92	      }
89	93	    }
90	94	  }
95	 
96	  @Override
97	  public void onConfigurationChanged(Configuration newConfig) {
98	    super.onConfigurationChanged(newConfig);
99	    ApplicationLifecycleDispatcher.onConfigurationChanged(this, newConfig);
100	  }
91	101	}

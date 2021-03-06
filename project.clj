(defproject steve-incanter "1.9.3-SNAPSHOT"
  :description "Incanter is a Clojure-based, R-like statistical programming and data visualization environment."
  :url "http://incanter.org/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:name "git" :url "https://github.com/incanter/incanter"}
  :min-lein-version "2.0.0"
  :dependencies [[steve-incanter/incanter-core "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-io "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-charts "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-mongodb "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-pdf "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-svg "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-latex "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-excel "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-sql "1.9.3-SNAPSHOT"]
                 [steve-incanter/incanter-zoo "1.9.3-SNAPSHOT"]
                 [swingrepl "1.3.0"
                  :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                 [org.clojure/clojure "1.8.0"]
                 ]
  
  :plugins [[lein-sub "0.3.0"]
            [lein-modules "0.3.8"]]
  
  :sub ["modules/incanter-core"
        "modules/incanter-io"
        "modules/incanter-charts"
        "modules/incanter-mongodb"
        "modules/incanter-pdf"
        "modules/incanter-svg"
        "modules/incanter-latex"
        "modules/incanter-excel"
        "modules/incanter-sql"
        "modules/incanter-zoo"
        "."]

  :modules {:dirs ["modules/incanter-core"
                   "modules/incanter-io"
                   "modules/incanter-charts"
                   "modules/incanter-mongodb"
                   "modules/incanter-pdf"
                   "modules/incanter-svg"
                   "modules/incanter-latex"
                   "modules/incanter-excel"
                   "modules/incanter-sql"
                   "modules/incanter-zoo"
                   "."]
            :subprocess false}
	  
  :profiles {:dev {:resource-paths ["data"]}
             :debug {:debug true}
             :uberjar {:dependencies [[reply "0.3.7" :exclusions [org.clojure/clojure]]
                                      [swingrepl "1.3.0"
                                       :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                                      ]
                       }
             }  
  
  :repl-options {:init-ns incanter.irepl
                 :resource-paths ["data"]
                 :init (do
                         (set! *print-length* 500)
                         (use 'clojure.repl))
                 }
  
  :javac-options ["-target" "1.7" "-source" "1.7"]
    
  :jvm-opts ["-Xmx1g" "-Djsse.enableSNIExtension=false"
             ~(str "-Dincanter.home=" (System/getProperty "user.dir"))]
  )

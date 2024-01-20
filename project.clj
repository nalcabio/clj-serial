(defproject bio.nalca/clj-serial "2.0.6"
  :description "Simple serial port library. Wraps PureJavaComm."
  :url "https://github.com/nalcabio/clj-serial"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [bio.nalca/purejavacomm "1.0.4"]]
  :repositories [["bio.nalca/purejavacomm" {:url "https://maven.pkg.github.com/nalcabio/purejavacomm"
                                            :username :env/GITHUB_USERNAME
                                            :password :env/GITHUB_PASSWORD}]]
  :deploy-repositories [["releases" {:url "https://maven.pkg.github.com/nalcabio/clj-serial"
                                     :username :env/GITHUB_USERNAME
                                     :password :env/GITHUB_PASSWORD}]]
  :profiles {:1.9 {:dependencies [[org.clojure/clojure "1.9.0"]]}}
  :scm {:name "git"
        :url "https://github.com/nalcabio/clj-serial"})

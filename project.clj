(defproject guestbook "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [ring-server "0.3.0"]

                 ;; JDBC dependencies
                 [org.clojure/java.jdbc "0.2.3"]
                 [org.xerial/sqlite-jdbc "3.7.2"]

                 ;; lib-noir
                 [lib-noir "0.8.0"]]

  :plugins [[lein-ring "0.8.7"]]
  :repl-options {:port 6439}
  :ring {:handler guestbook.handler/app
         :init guestbook.handler/init
         :destroy guestbook.handler/destroy}
  :aot :all
  :profiles {:production {:ring {:open-browser? false, :stacktraces? false, :auto-reload? false}}
             :dev {:ring {:open-browser? false, :stacktraces? false, :auto-reload? false}
                   :dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.0"]]}})

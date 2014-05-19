(require '[cheshire.core])
(require '[hiccup.core])

(defn urls-for [images]
  (-> images
      (clojure.string/split #"\n")
      (->> (map clojure.string/trim))))

(defn image-data [url]
  (->> url
       (str "http://backend.deviantart.com/oembed?url=")
       slurp
       cheshire.core/parse-string))

(def image-data-memoized (memoize image-data))

(defn file-exists? [file]
  (.exists (clojure.java.io/as-file file)))

(defn file-name-from-url [url]
  (-> url
      clojure.java.io/as-url
      .getFile
      (clojure.string/split #"/")
      last
      (clojure.string/replace #"_by_.*\." ".")
      (clojure.string/replace #"_" "-")))

(defn copy-uri-to-file [uri]
  (let [file-name (file-name-from-url uri)
        local-file-name (str (System/getProperty "user.dir") "/moolversin.github.com/public/works/" file-name)]
    (when-not (file-exists? local-file-name)
      (with-open [in (clojure.java.io/input-stream uri)
                  out (clojure.java.io/output-stream local-file-name)]
        (clojure.java.io/copy in out)))))

(defn image [main-url]
  (let [data (image-data-memoized main-url)
        _ (copy-uri-to-file (data "url"))
        url (str "/works/" (file-name-from-url (data "url")))
        title (data "title")]
    [:a.item-link {:href url
                   :title title
                   :data-lightbox "images"
                   :data-title (hiccup.core/html
                                 title
                                 [:br]
                                 [:a {:href main-url} "View on DeviantArt"])}
     [:div.item.w1
      [:img {:src url :alt title}]
      [:div.hide.overflow
       [:h2 title]]]]))

(defn logo []
  [:div.row
   [:div.small-3.small-centered.column
    [:a {:href "/"} [:img.logo {:src "/img/logo.png"}]]]])

(defn main-nav []
  [:div.row.header-links
   [:div.small-4.column.small-centered.text-center
    [:ul.inline-list
     [:li [:a {:href "/"} "Home"]]
     [:li [:a {:href "/portraits.html"} "Gallery"]]
     [:li [:a {:href "http://moolver-sin.deviantart.com/prints/"
               :target "_blank"}
           "Buy prints"]]
     [:li [:a {:href "/about.html"} "About"]]]]])

(defn is-active? [checking current]
  (if (= checking current)
    "active nav-item"
    "nav-item"))

(defn galleries-nav [current]
  [:div.row.galleries-links
   [:div.small-5.column.small-centered.text-center
    [:ul.inline-list
     [:li [:a {:href "/portraits.html"
               :class (is-active? "portraits" current)}
           "Portraits"]]
     [:li [:a {:href "/surrealism.html"
               :class (is-active? "surrealism" current)}
           "Surrealism"]]
     [:li [:a {:href "/concept_art.html"
               :class (is-active? "concept_art" current)}
           "Concept Art"]]
     [:li [:a {:href "/sketches.html"
               :class (is-active? "sketches" current)}
           "Sketches"]]]]])

(defn to-images-html [coll]
  (map image coll))

(def ga-script  "function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                 (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                 m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
                 (window,document,'script','//www.google-analytics.com/analytics.js','ga');

                 ga('create', 'UA-51145039-1', 'lovesoltan.com');
                 ga('send', 'pageview');")

[:head
 [:meta {:name "description"
         :content (str "Lubov Soltan. Artist living in Amsterdam, Netherlands. lubarazgildeeva@gmail.com. "
                       (:description site))}]
 [:meta {:charset (:charset site)}]
 [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
 [:link {:href "/favicon.ico" :rel "shortcut icon"}]
 [:link {:href "/favicon.gif" :rel "icon" :type "image/gif"}]
 [:title (:title site)]
 (js ["/js/jquery-1.11.0.min.js"
      "/js/lightbox.min.js"])
 (css ["/css/normalize.css"
       "/css/foundation.min.css"
       "/css/main.css"
       "/css/lightbox.css"])]
; /head

[:body
 [:script ga-script]
 [:div
  contents]
 (js ["/js/masonry.pkgd.min.js"
      "/js/main.js"])]
; /body

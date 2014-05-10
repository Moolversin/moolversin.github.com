
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

(defn image [main-url]
  (let [data (image-data-memoized main-url)
        url (data "url")
        title (data "title")]
    [:a.item-link {:href url
                   :data-lightbox "images"
                   :data-title (hiccup.core/html
                                 title
                                 [:br]
                                 [:a {:href main-url} "View on DeviantArt"])}
     [:div.item.w1
      [:img {:src url}]
      [:div.hide.overflow
       [:h2 title]]]]))

(defn logo []
  [:div.row
   [:div.small-3.small-centered.column
    [:img.logo {:src "/img/logo.png"}]]])

(defn main-nav []
  [:div.row.header-links
   [:div.small-5.column.small-centered.text-center
    [:ul.inline-list
     [:li [:a {:href "/"} "Home"]]
     [:li [:a {:href "/portraits.html"} "Gallery"]]
     [:li [:a {:href "http://moolver-sin.deviantart.com/prints/"
               :target "_blank"}
           "Buy prints"]]
     [:li [:a {:href "/about.html"} "About"]]
     [:li [:a {:href "/contact.html"} "Contact"]]]]])

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

[:head
 [:meta {:name "description"
         :content "Lubov Soltan. Love Soltan. MoolverSin. Artist living in Amsterdam, Netherlands. lubarazgildeeva@gmail.com"}]
 [:meta {:charset (:charset site)}]
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
 [:div
  contents]
 (js ["/js/masonry.pkgd.min.js"
      "/js/main.js"])]
; /body

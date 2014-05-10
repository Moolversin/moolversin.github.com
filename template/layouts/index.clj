
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

  [:div.row
   [:div.small-3.small-centered.column
    [:img.logo {:src "/img/logo.png"}]]]

  [:div.row.header-links
   [:div.small-5.column.small-centered.text-center
    [:ul.inline-list
     [:li [:a {:href "/"} "Home"]]
     [:li [:a {:href "http://moolver-sin.deviantart.com/gallery/"
               :target "_blank"}
           "Gallery"]]
     [:li [:a {:href "http://moolver-sin.deviantart.com/prints/"
               :target "_blank"}
           "Prints"]]
     [:li [:a {:href "/about.html"} "About"]]
     [:li [:a {:href "/contact.html"} "Contact"]]]]]

  contents]
 (js ["/js/masonry.pkgd.min.js"
      "/js/main.js"])]
; /body

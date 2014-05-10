; @layout  index
; @title   Love Soltan

[:div.row
 [:div.small-3.small-centered.column
  [:img.logo {:src "http://placehold.it/160x60&text=Logo"}]]]

[:div.row.header-links
 [:div.small-5.column.small-centered.text-center
  [:ul.inline-list
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]]]]

(require '[cheshire.core])
(require '[hiccup.core])

(def images
  "http://moolver-sin.deviantart.com/art/Dez-Fafara-204484050
   http://moolver-sin.deviantart.com/art/Christian-Bale-209830247
   http://moolver-sin.deviantart.com/art/Max-207549641
   http://moolver-sin.deviantart.com/art/Small-400134129
   http://moolver-sin.deviantart.com/art/Kate-the-mysterious-367590887
   http://moolver-sin.deviantart.com/art/Girl-Is-Born-371835480
   http://moolver-sin.deviantart.com/art/Joey-Jordisson-Murderdolls-295288406
   http://moolver-sin.deviantart.com/art/Tanja-362056439
   http://moolver-sin.deviantart.com/art/My-sweet-Mary-290286989
   http://moolver-sin.deviantart.com/art/Girl-in-hat-286862494
   http://moolver-sin.deviantart.com/art/Max-Gonzih-2-279182089
   http://moolver-sin.deviantart.com/art/Khal-Drogo-259801587
   http://moolver-sin.deviantart.com/art/Peter-Tagtgren-213246176
   http://moolver-sin.deviantart.com/art/Kerry-King-205508133
   http://moolver-sin.deviantart.com/art/Tree-cats-196672327
   http://moolver-sin.deviantart.com/art/Robot-and-skeleton-196671200
   http://moolver-sin.deviantart.com/art/Maxim-196557811
   http://moolver-sin.deviantart.com/art/Embryo-257361890
   http://moolver-sin.deviantart.com/art/Hunter-404507800
   http://moolver-sin.deviantart.com/art/Glance-406528379
   http://moolver-sin.deviantart.com/art/Blue-Girl-356754285")

(def opts
  [{:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w1"}
   {:class "w2"}])

(def urls (-> images
              (clojure.string/split #"\n")
              (->> (map clojure.string/trim))))

(defn image-data [url]
  (->> url
       (str "http://backend.deviantart.com/oembed?url=")
       slurp
       cheshire.core/parse-string))

(def image-data-memoized (memoize image-data))

(defn image [[main-url opts]]
  (let [data (image-data-memoized main-url)
        url (data "url")
        title (data "title")
        category (data "category")]
    [:a.item-link {:href url
                   :data-lightbox "images"
                   :data-title (hiccup.core/html
                                 [:a {:href main-url} "View on DeviantArt"]
                                 [:br]
                                 title
                                 [:br]
                                 category)}
     [:div {:class (str "item "(:class opts))}
      [:img {:src url}]
      [:div.hide.overflow
       [:h2 title]
       [:br]
       [:p.description category]]]]))

[:div#container
 (pmap image (zipmap urls opts))]

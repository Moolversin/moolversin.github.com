[:head
 [:meta {:charset (:charset site)}]
 [:title (:title site)]
 (js ["/js/masonry.pkgd.min.js"
      "/js/jquery-1.11.0.min.js"
      "/js/lightbox.min.js"])
 (css ["/css/normalize.css"
       "/css/foundation.min.css"
       "/css/main.css"
       "/css/lightbox.css"])]
; /head

[:body
 [:div contents]
 (js ["/js/main.js"])]
; /body

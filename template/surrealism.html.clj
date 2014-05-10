; @layout  index
; @title   Lubov Soltan - Home

(def images
  "http://moolver-sin.deviantart.com/art/Glance-406528379
   http://moolver-sin.deviantart.com/art/Hunter-404507800
   http://moolver-sin.deviantart.com/art/Girl-Is-Born-371835480
   http://moolver-sin.deviantart.com/art/Bound-263240106
   http://moolver-sin.deviantart.com/art/Embryo-257361890
   http://moolver-sin.deviantart.com/art/Mary-The-Dragon-200429009
   http://moolver-sin.deviantart.com/art/House-near-the-park-196752010
   http://moolver-sin.deviantart.com/art/junk-yard-196684301
   http://moolver-sin.deviantart.com/art/Ex-libris-quot-Books-quot-196683893
   http://moolver-sin.deviantart.com/art/Tree-cats-196672327
   http://moolver-sin.deviantart.com/art/Robot-and-skeleton-196671200
   http://moolver-sin.deviantart.com/art/Windows-196669814
   http://moolver-sin.deviantart.com/art/Above-the-city-196668264
   http://moolver-sin.deviantart.com/art/Thought-generator-196667639
   http://moolver-sin.deviantart.com/art/Cat-collector-196667024")

[:div.header
 (logo)
 (main-nav)
 (galleries-nav "surrealism")]

[:div#container
 (pmap image (urls-for images))]

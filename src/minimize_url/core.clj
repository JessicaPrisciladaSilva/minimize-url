(ns minimize-url.core)


(def list-url (ref {}))

(defn rand-str
  "Generate random string with len pass for parameter"
  [len]
  (apply str (take len (repeatedly #(char (+ (rand 26) 65))))))


(defn shorten-url
  "Create Shorten the URL"
  [path len]
  (str path (rand-str len)))

(defn url->shorten-url
  "Convert url in shorten url"
  [url f len]
  (let [new-url (f "http://nbk.nu/" len)]
    (dosync
      (alter list-url assoc (:url url) new-url))))
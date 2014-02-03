(ns serial.test.core
  (:require [clojure.test :refer :all]
            [serial.core :refer :all])
  (:import [purejavacomm CommPortIdentifier]
           [java.util Enumeration]
           [java.io ByteArrayOutputStream]
           [java.nio ByteBuffer]))

(deftest port-ids-test
  (testing "Empty port identifiers"
    (with-redefs [raw-port-ids (fn [] (proxy [Enumeration] []
                                        (hasMoreElements [] false)
                                        (nextElement [] nil)))]
      (let [ports (port-ids)]
        (is (nil? ports ))))
    )
  )


(defn- mock-port
  []
  {:out-stream (ByteArrayOutputStream.)})

(defn- read-last
  [port]
    (-> port
        :out-stream
        .toByteArray
        ByteBuffer/wrap
        .get))

(deftest write-test
  (testing "Bytes should be written to the Port's output stream"
    (let [port (mock-port)]
      (write port (byte-array (.getBytes "Hello" "UTF-8")))
      (is (= "Hello"
             (.toString (:out-stream port) "UTF-8")))))

  (testing "An int should be written to the Port's output stream"
    (let [port (mock-port)]
      (write port 12)
      (is (= (byte 12) (read-last port)))))
  )

(run-tests)
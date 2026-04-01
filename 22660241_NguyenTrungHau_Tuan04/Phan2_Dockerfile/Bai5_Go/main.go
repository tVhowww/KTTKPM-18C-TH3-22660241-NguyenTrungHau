package main

import (
	"fmt"
	"net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello, Docker Go! Ung dung Golang cua ban dang chay mượt mà.")
}

func main() {
	http.HandleFunc("/", handler)
	fmt.Println("Server Golang dang chay o cong 8080...")
	
	// Khởi chạy server ở cổng 8080
	if err := http.ListenAndServe(":8080", nil); err != nil {
		fmt.Println("Loi khoi chay server:", err)
	}
}
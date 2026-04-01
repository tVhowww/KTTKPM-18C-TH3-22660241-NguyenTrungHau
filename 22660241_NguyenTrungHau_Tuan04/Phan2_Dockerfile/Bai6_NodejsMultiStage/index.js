const express = require("express");
const app = express();
const port = 3000;

app.get("/", (req, res) => {
  res.send(
    "Xin chào! Ứng dụng này được build bằng kỹ thuật Multi-stage siêu tối ưu!",
  );
});

app.listen(port, () => {
  console.log(`Server Node.js đang chạy tại cổng ${port}`);
});

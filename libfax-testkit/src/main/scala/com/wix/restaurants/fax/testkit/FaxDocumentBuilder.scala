package com.wix.restaurants.fax.testkit

trait FaxDocumentBuilder {
  /**
   * @return an HTML fax document for tests.
   */
  def buildHtmlFaxDocument(): String = {
    // We explicitly use non English characters to test encoding issues.
    """|<!doctype html>
       |
       |<html lang="en">
       |<head>
       |  <meta charset="utf-8">
       |  <title>Some title</title>
       |</head>
       |
       |<body>
       |  <p>This is a paragraph with English text.</p>
       |  <p>זאת פסקה עם טקסט בעברית.</p>
       |</body>
       |</html>""".stripMargin
  }
}

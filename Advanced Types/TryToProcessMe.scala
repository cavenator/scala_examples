object TryToProcessMe {
    import java.io._

    type Closable = { def close() }
     
    def processAndClose[ExtendedClosable <: Closable, ReturnType](target: ExtendedClosable, fun:(ExtendedClosable) => ReturnType):ReturnType = {
       try {
           fun(target)
       } finally {
           target.close
       }
    }


    def readThrough(source: BufferedReader)= {
       var line = source.readLine
       while (line != null) {
           println(line)
           line = source.readLine
       }
    }

}


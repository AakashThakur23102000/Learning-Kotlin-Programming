import { View, Text, NativeModules } from 'react-native'
import React, { useEffect } from 'react'

const App = () => {

  console.log("Js Page gets loaded......");

  const { FirstNativeModule, SecondNativeModule } = NativeModules

  useEffect(() => {
    FirstNativeModule.printFirst()
      .then((message: any) => console.log(message))
      .catch((error: any) => console.error(error));

    SecondNativeModule.printSecond()
      .then((message: any) => console.log(message))
      .catch((error: any) => console.error(error));

    FirstNativeModule.printThird()
      .then((message: any) => console.log(message))
      .catch((error: any) => console.error(error));

  }, [])

  return (
    <View>
      <Text>App</Text>
    </View>
  )
}

export default App
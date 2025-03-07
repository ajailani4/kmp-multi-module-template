# Modularization in a Kotlin Multiplatform Project

## Design
This template groups all modules to be four groups: _core_, _api_, _presentation-android_, and _presentation-ios_. Each module group consists of multiple modules—or frameworks for iOS apps. For example, _core_ group includes _network_ module and _entity_ module.

- _api_ depends on _core_
- **shared** depends on _core_ and _api_ modules.
- **composeApp** depends on _presentation-android_ and **shared** modules.
- **iosApp** depends on _presentation-ios_ frameworks and **shared** module.

**Note: api module wraps data and domain layers. You can also separate them into distinct modules for data and domain layers. It depends on your requirements.**

![image](https://github.com/user-attachments/assets/4115f458-8eb4-4c5f-bb3a-4051c3beedb6)

## Demo
### Android
https://github.com/user-attachments/assets/ecf070e0-8c34-4e5f-b457-6ab9980f1f54

### iOS
https://github.com/user-attachments/assets/3cc1e817-7384-4de7-880f-2db90d8a4a91

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

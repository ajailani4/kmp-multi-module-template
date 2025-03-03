import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init() {
        DIHelper().doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

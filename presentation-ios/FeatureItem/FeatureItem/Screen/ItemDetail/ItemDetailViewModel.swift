import Foundation
import Shared

extension ItemDetailScreen {
    @MainActor
    class ItemDetailView: ObservableObject {
        private let getItemUseCase = DIHelper().getItemUseCase
        
        @Published var uiState = ItemDetailUiState()
        
        func getItemDetail() {
            uiState.isLoading = true
            
            Task {
                for await result in getItemUseCase.invoke() {
                    switch result {
                    case is NetworkApiResultSuccess<EntityExampleItem>:
                        let successResult = result as! NetworkApiResultSuccess<EntityExampleItem>
                        uiState.isLoading = false
                        uiState.item = successResult.data
                        
                    case is NetworkApiResultError<EntityExampleItem>:
                        let errorResult = result as! NetworkApiResultError<EntityExampleItem>
                        uiState.isLoading = false
                        uiState.errorMessage = errorResult.message
                        
                    default:
                        break
                    }
                }
            }
        }
    }
}

package com.example.counter

class CounterPresenter {

    private val model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
        view.showResult(model.getCount())
    }

    fun onIncrement() {
        model.increment()
        view?.showResult(model.getCount())
        when(model.getCount()){
            10->view?.showToast("поздравляем!")
            15->view?.tvColorGreen()
        }
    }

    fun onDecrement() {
        model.decrement()
        view?.showResult(model.getCount())
    }

    fun detachView() {
        view = null
    }
}
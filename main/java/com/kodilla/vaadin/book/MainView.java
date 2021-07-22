package com.kodilla.vaadin.book;

import com.kodilla.vaadin.domain.Book;
import com.kodilla.vaadin.domain.BookForm;
import com.kodilla.vaadin.domain.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout{

        private BookService bookService = BookService.getInstance();
        private Grid<Book> grid = new Grid<>(Book.class);
        private TextField filter = new TextField();
        private Binder<Book> binder = new Binder<Book>(Book.class);
        private BookForm form = new BookForm(this);
        private Button addNewBook = new Button("Add new book");

   public MainView() {
       filter.setPlaceholder("Filter by title...");
       filter.setClearButtonVisible(true);
       filter.setValueChangeMode(ValueChangeMode.EAGER);
       filter.addValueChangeListener(e -> update());
       grid.setColumns("title", "author", "publicationYear", "type");

       addNewBook.addClickListener(e -> {
           grid.asSingleSelect().clear();
           form.setBook(new Book());
       });
       HorizontalLayout toolbar = new HorizontalLayout(filter, addNewBook);

       HorizontalLayout mainContent = new HorizontalLayout(grid, form);
       mainContent.setSizeFull();
       grid.setSizeFull();
       form.setBook(null);

       add(toolbar, mainContent);
       setSizeFull();
       refresh();

    grid.asSingleSelect().addValueChangeListener(event -> form.setBook(grid.asSingleSelect().getValue()));
    }


    public void refresh() {
        grid.setItems(bookService.getBooks());
    }
    private void update() {
        grid.setItems(bookService.findByTitle(filter.getValue()));
    }
}

(function() {
    const Editor = toastui.Editor;
    const editor = new Editor({
        el: document.querySelector('#editor'),
        height: 'auto',
        minHeight: '500px',
        initialEditType: 'markdown',
        previewStyle: 'vertical'
    });

    $('#save-btn').on('click', function() {
        console.log(editor.getHTML());
    });
})();